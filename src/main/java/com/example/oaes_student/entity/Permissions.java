package com.example.oaes_student.entity;

public class Permissions {
    private boolean termsAndConditions;
    private boolean micAndCamera;

    public Permissions(boolean termsAndConditions, boolean micAndCamera) {
        this.termsAndConditions = termsAndConditions;
        this.micAndCamera = micAndCamera;
    }

    public Permissions() {
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "termsAndConditions=" + termsAndConditions +
                ", micAndCamera=" + micAndCamera +
                '}';
    }

    public boolean isTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(boolean termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public boolean isMicAndCamera() {
        return micAndCamera;
    }

    public void setMicAndCamera(boolean micAndCamera) {
        this.micAndCamera = micAndCamera;
    }
}
