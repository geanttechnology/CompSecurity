.class Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
.super Ljava/lang/Object;
.source "UserSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/UserSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SettingsButtonInfo"
.end annotation


# instance fields
.field public fragmentData:Landroid/os/Bundle;

.field public fragmentToLaunch:Ljava/lang/Class;

.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserSettingsFragment;

.field public trackingLabel:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V
    .locals 1

    .prologue
    .line 351
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->this$0:Lcom/poshmark/ui/fragments/UserSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 353
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    return-void
.end method
