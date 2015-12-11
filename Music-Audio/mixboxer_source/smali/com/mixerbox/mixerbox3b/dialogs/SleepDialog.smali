.class public Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;
.super Landroid/app/AlertDialog$Builder;
.source "SourceFile"


# instance fields
.field private ctx:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 29
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;

    .line 30
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->getContent()V

    .line 31
    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method private getContent()V
    .locals 3

    .prologue
    .line 35
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 36
    const v1, 0x7f03002a

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 37
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 39
    const v1, 0x7f070062

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 40
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setSelection(I)V

    .line 42
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800f0

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 43
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08007e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;

    invoke-direct {v2, p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;Landroid/widget/EditText;)V

    invoke-virtual {p0, v1, v2}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 87
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080063

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$2;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)V

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 92
    return-void
.end method
