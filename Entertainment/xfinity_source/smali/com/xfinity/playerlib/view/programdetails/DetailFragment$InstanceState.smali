.class public Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;
.super Lcom/xfinity/playerlib/view/BaseInstanceState;
.source "DetailFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InstanceState"
.end annotation


# static fields
.field protected static final EXTRA_BUNDLE_PARAMS:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 1181
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->EXTRA_BUNDLE_PARAMS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1179
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/BaseInstanceState;-><init>()V

    return-void
.end method

.method public static fromBundle(Landroid/os/Bundle;)Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;
    .locals 1
    .param p0, "in"    # Landroid/os/Bundle;

    .prologue
    .line 1195
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->EXTRA_BUNDLE_PARAMS:Ljava/lang/String;

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    return-object v0
.end method


# virtual methods
.method public addToBundle(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .param p1, "out"    # Landroid/os/Bundle;

    .prologue
    .line 1190
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->EXTRA_BUNDLE_PARAMS:Ljava/lang/String;

    invoke-virtual {p1, v0, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 1191
    return-object p1
.end method
