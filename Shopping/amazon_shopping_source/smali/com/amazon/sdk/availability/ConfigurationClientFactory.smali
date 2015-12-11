.class final Lcom/amazon/sdk/availability/ConfigurationClientFactory;
.super Ljava/lang/Object;
.source "ConfigurationClientFactory.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    return-void
.end method

.method public static getConfigurationClient()Lcom/amazon/sdk/availability/ConfigurationClient;
    .locals 1

    .prologue
    .line 16
    new-instance v0, Lcom/amazon/sdk/availability/ConfigurationClientImpl;

    invoke-direct {v0}, Lcom/amazon/sdk/availability/ConfigurationClientImpl;-><init>()V

    return-object v0
.end method
