.class public final Lcom/amazon/sdk/availability/MeasurementManagerFactory;
.super Ljava/lang/Object;
.source "MeasurementManagerFactory.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    return-void
.end method

.method public static getMeasurementManager()Lcom/amazon/sdk/availability/MeasurementManager;
    .locals 1

    .prologue
    .line 16
    new-instance v0, Lcom/amazon/sdk/availability/MeasurementManagerImpl;

    invoke-direct {v0}, Lcom/amazon/sdk/availability/MeasurementManagerImpl;-><init>()V

    return-object v0
.end method
