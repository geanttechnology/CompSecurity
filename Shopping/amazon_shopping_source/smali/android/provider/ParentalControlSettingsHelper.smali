.class public Landroid/provider/ParentalControlSettingsHelper;
.super Ljava/lang/Object;
.source "ParentalControlSettingsHelper.java"


# instance fields
.field private mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/provider/ParentalControlSettingsHelper;->mContext:Landroid/content/Context;

    .line 20
    iput-object p1, p0, Landroid/provider/ParentalControlSettingsHelper;->mContext:Landroid/content/Context;

    .line 21
    return-void
.end method
