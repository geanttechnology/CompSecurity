.class public Lcom/poshmark/data_model/models/ExternalPermissions;
.super Ljava/lang/Object;
.source "ExternalPermissions.java"


# instance fields
.field public email:I

.field public public_profile:I

.field public publish_actions:I

.field public user_friends:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    iput v0, p0, Lcom/poshmark/data_model/models/ExternalPermissions;->user_friends:I

    .line 8
    iput v0, p0, Lcom/poshmark/data_model/models/ExternalPermissions;->email:I

    .line 9
    iput v0, p0, Lcom/poshmark/data_model/models/ExternalPermissions;->public_profile:I

    .line 10
    iput v0, p0, Lcom/poshmark/data_model/models/ExternalPermissions;->publish_actions:I

    return-void
.end method
