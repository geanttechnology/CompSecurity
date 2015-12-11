.class public interface abstract Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;
.super Ljava/lang/Object;
.source "Logger.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/Logger;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "AvailabilityLogObserver"
.end annotation


# virtual methods
.method public abstract e(Ljava/lang/String;)V
.end method

.method public abstract e(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public abstract i(Ljava/lang/String;)V
.end method

.method public abstract measurementRecorded(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract measurementsSubmitted(ZJLjava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract syncConfigurationScheduled(JZ)V
.end method

.method public abstract v(Ljava/lang/String;)V
.end method

.method public abstract v(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public abstract w(Ljava/lang/String;)V
.end method

.method public abstract w(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method
