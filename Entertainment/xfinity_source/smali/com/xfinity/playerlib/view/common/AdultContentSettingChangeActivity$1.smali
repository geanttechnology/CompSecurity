.class Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$1;
.super Ljava/lang/Object;
.source "AdultContentSettingChangeActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$1;->this$0:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$1;->this$0:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->finish()V

    .line 39
    return-void
.end method
