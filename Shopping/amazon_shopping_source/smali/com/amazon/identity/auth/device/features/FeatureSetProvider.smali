.class public Lcom/amazon/identity/auth/device/features/FeatureSetProvider;
.super Lcom/amazon/identity/auth/device/features/FeatureSet;
.source "FeatureSetProvider.java"


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/features/FeatureSet;-><init>()V

    .line 12
    if-nez p1, :cond_0

    .line 14
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "context is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 17
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;->mContext:Landroid/content/Context;

    .line 18
    return-void
.end method


# virtual methods
.method public hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z
    .locals 1
    .param p1, "feature"    # Lcom/amazon/identity/auth/device/features/Feature;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;->mContext:Landroid/content/Context;

    invoke-virtual {p1, v0}, Lcom/amazon/identity/auth/device/features/Feature;->fetchValue(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method
