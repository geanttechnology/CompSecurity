.class public Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature;
.super Ljava/lang/Object;
.source "ShareViaFBMessengerFeature.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature$Feature;
    }
.end annotation


# instance fields
.field android:Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature$Feature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    return-void
.end method


# virtual methods
.method public isEnabled()Z
    .locals 1

    .prologue
    .line 9
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature;->android:Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature$Feature;

    if-nez v0, :cond_0

    .line 10
    const/4 v0, 0x0

    .line 12
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature;->android:Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature$Feature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature$Feature;->enabled:Z

    goto :goto_0
.end method
