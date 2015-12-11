.class public Lcom/poshmark/notifications/PMNotificationDetails;
.super Ljava/lang/Object;
.source "PMNotificationDetails.java"


# instance fields
.field id:I

.field type:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    const/4 v0, 0x0

    iput v0, p0, Lcom/poshmark/notifications/PMNotificationDetails;->type:I

    return-void
.end method
