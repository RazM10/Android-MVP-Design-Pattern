package org.myself.android_mvp_design;

public class Presenter {

    Model model;
    PresenterListener listener;

    public Presenter(PresenterListener listener) {
        this.model = new Model();
        this.listener = listener;
    }

    public void updateName(String name){
        model.setName(name);
        listener.getModelFullInfo(model.getFullInfo());
    }

    public void updateEmail(String email){
        model.setEmail(email);
        listener.getModelFullInfo(model.getFullInfo());
    }

    public void updateAddress(String address){
        model.setAddress(address);
        listener.getModelFullInfo(model.getFullInfo());
    }

    public interface PresenterListener{
        void getModelFullInfo(String info);
        void showProgressBar();
        void hideProgressBar();
    }
}
