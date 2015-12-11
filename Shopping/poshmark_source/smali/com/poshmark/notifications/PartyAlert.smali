.class public Lcom/poshmark/notifications/PartyAlert;
.super Ljava/lang/Object;
.source "PartyAlert.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static showAlert(Lcom/poshmark/ui/PMActivity;Landroid/os/Bundle;Ljava/lang/String;)V
    .locals 5
    .param p0, "topActivity"    # Lcom/poshmark/ui/PMActivity;
    .param p1, "bundle"    # Landroid/os/Bundle;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 26
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-direct {v1, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 29
    .local v1, "alertDialogBuilder":Landroid/app/AlertDialog$Builder;
    const-string v2, "Party is ON!"

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 32
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is happening now!"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    const-string v3, "Join?"

    new-instance v4, Lcom/poshmark/notifications/PartyAlert$2;

    invoke-direct {v4, p0, p1}, Lcom/poshmark/notifications/PartyAlert$2;-><init>(Lcom/poshmark/ui/PMActivity;Landroid/os/Bundle;)V

    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    const-string v3, "Cancel"

    new-instance v4, Lcom/poshmark/notifications/PartyAlert$1;

    invoke-direct {v4}, Lcom/poshmark/notifications/PartyAlert$1;-><init>()V

    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 49
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 52
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 53
    return-void
.end method

.method public static showPartyAlert(Landroid/os/Bundle;)V
    .locals 3
    .param p0, "partyBundle"    # Landroid/os/Bundle;

    .prologue
    .line 18
    const-string v2, "PARTY_TITLE"

    invoke-virtual {p0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 19
    .local v0, "partyTitle":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 20
    .local v1, "topActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 21
    invoke-static {v1, p0, v0}, Lcom/poshmark/notifications/PartyAlert;->showAlert(Lcom/poshmark/ui/PMActivity;Landroid/os/Bundle;Ljava/lang/String;)V

    .line 23
    :cond_0
    return-void
.end method
