package com.edisonmaciel.dslearn.observers;

import com.edisonmaciel.dslearn.entities.Deliver;

public interface DeliverRevisionObserver {

    void onSaveRevision(Deliver deliver);
}
