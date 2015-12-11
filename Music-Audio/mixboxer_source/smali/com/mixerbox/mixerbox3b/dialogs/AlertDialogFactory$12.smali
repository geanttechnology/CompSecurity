.class final Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory$12;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic val$activity:Landroid/app/Activity;


# direct methods
.method constructor <init>(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory$12;->val$activity:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 143
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 144
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory$12;->val$activity:Landroid/app/Activity;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->dialogDevice:Landroid/app/Dialog;

    .line 145
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory$12;->val$activity:Landroid/app/Activity;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.settings.DEVICE_INFO_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 146
    return-void
.end method
