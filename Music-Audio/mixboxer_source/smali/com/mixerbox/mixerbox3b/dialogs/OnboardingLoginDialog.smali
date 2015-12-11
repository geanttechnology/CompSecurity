.class public Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;
.super Landroid/app/AlertDialog$Builder;
.source "SourceFile"


# instance fields
.field private ctx:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 19
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;

    .line 20
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->getContent()V

    .line 21
    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method private getContent()V
    .locals 3

    .prologue
    .line 25
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 26
    const v1, 0x7f030029

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 27
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 28
    const v1, 0x7f070063

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 29
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08012a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 30
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080129

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 31
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 33
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08007e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$1;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)V

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 47
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080063

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$2;-><init>(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)V

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 54
    return-void
.end method
