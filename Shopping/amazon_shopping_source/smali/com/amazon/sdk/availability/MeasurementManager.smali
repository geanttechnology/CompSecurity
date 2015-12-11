.class public interface abstract Lcom/amazon/sdk/availability/MeasurementManager;
.super Ljava/lang/Object;
.source "MeasurementManager.java"


# virtual methods
.method public abstract putMeasurement(Landroid/content/Context;Lcom/amazon/sdk/availability/Measurement;)V
.end method

.method public abstract putMeasurement(Landroid/content/Context;Lcom/amazon/sdk/availability/Measurement;Ljava/io/Serializable;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Ljava/io/Serializable;",
            ":",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/io/File;",
            ">;>(",
            "Landroid/content/Context;",
            "Lcom/amazon/sdk/availability/Measurement;",
            "TT;)V"
        }
    .end annotation
.end method

.method public abstract setIdentityInformation(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
.end method
