package com.xyc.fastdevproject.eventBus;

import com.xyc.fastdevproject.model.DefaultEventModel;

public class DefaultEvent {
    private DefaultEventModel eventModel;

    public DefaultEvent(DefaultEventModel eventModel) {
        this.eventModel = eventModel;
    }

    public DefaultEventModel getEventModel() {
        return eventModel;
    }
}
