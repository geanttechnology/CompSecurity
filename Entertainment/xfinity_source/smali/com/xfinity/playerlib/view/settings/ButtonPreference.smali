.class public Lcom/xfinity/playerlib/view/settings/ButtonPreference;
.super Landroid/preference/Preference;
.source "ButtonPreference.java"


# instance fields
.field private buttonListener:Landroid/view/View$OnClickListener;

.field private loadingProgressBar:Landroid/widget/ProgressBar;

.field private rightButton:Landroid/widget/Button;

.field private rightButtonString:Ljava/lang/String;

.field private summaryString:Ljava/lang/String;

.field private summaryText:Landroid/widget/TextView;

.field private titleString:Ljava/lang/String;

.field private titleText:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 32
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 33
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v0, 0x0

    .line 28
    invoke-direct {p0, p1, p2, p3}, Landroid/preference/Preference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 21
    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButtonString:Ljava/lang/String;

    .line 22
    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->titleString:Ljava/lang/String;

    .line 23
    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->summaryString:Ljava/lang/String;

    .line 24
    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->loadingProgressBar:Landroid/widget/ProgressBar;

    .line 25
    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->buttonListener:Landroid/view/View$OnClickListener;

    .line 29
    return-void
.end method


# virtual methods
.method protected onCreateView(Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v4, 0x0

    .line 37
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->getContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "layout_inflater"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 38
    .local v0, "inflater":Landroid/view/LayoutInflater;
    sget v2, Lcom/xfinity/playerlib/R$layout;->button_preference:I

    invoke-virtual {v0, v2, p1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 40
    .local v1, "layout":Landroid/widget/LinearLayout;
    sget v2, Lcom/xfinity/playerlib/R$id;->right_button:I

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButton:Landroid/widget/Button;

    .line 41
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButtonString:Ljava/lang/String;

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->setRightButtonText(Ljava/lang/String;)V

    .line 42
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->buttonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->setRightButtonClickListener(Landroid/view/View$OnClickListener;)V

    .line 43
    sget v2, Lcom/xfinity/playerlib/R$id;->title_text:I

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->titleText:Landroid/widget/TextView;

    .line 44
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->titleString:Ljava/lang/String;

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->setTitleText(Ljava/lang/String;)V

    .line 45
    sget v2, Lcom/xfinity/playerlib/R$id;->summary_text:I

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->summaryText:Landroid/widget/TextView;

    .line 46
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->summaryString:Ljava/lang/String;

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->setSummaryText(Ljava/lang/String;)V

    .line 48
    sget v2, Lcom/xfinity/playerlib/R$id;->loading_progressbar:I

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ProgressBar;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->loadingProgressBar:Landroid/widget/ProgressBar;

    .line 49
    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->setSelectable(Z)V

    .line 50
    return-object v1
.end method

.method public setRightButtonClickListener(Landroid/view/View$OnClickListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButton:Landroid/widget/Button;

    if-nez v0, :cond_0

    .line 70
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->buttonListener:Landroid/view/View$OnClickListener;

    .line 75
    :goto_0
    return-void

    .line 74
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButton:Landroid/widget/Button;

    invoke-virtual {v0, p1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method public setRightButtonText(Ljava/lang/String;)V
    .locals 2
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButton:Landroid/widget/Button;

    if-nez v0, :cond_0

    .line 56
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButtonString:Ljava/lang/String;

    .line 66
    :goto_0
    return-void

    .line 60
    :cond_0
    if-nez p1, :cond_1

    .line 61
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButton:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_0

    .line 63
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButton:Landroid/widget/Button;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 64
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButton:Landroid/widget/Button;

    invoke-virtual {v0, p1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public setSummaryText(Ljava/lang/String;)V
    .locals 2
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->summaryText:Landroid/widget/TextView;

    if-nez v0, :cond_0

    .line 95
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->summaryString:Ljava/lang/String;

    .line 105
    :goto_0
    return-void

    .line 99
    :cond_0
    if-nez p1, :cond_1

    .line 100
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->summaryText:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 102
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->summaryText:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 103
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->summaryText:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public setTitleText(Ljava/lang/String;)V
    .locals 2
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 79
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->titleText:Landroid/widget/TextView;

    if-nez v0, :cond_0

    .line 80
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->titleString:Ljava/lang/String;

    .line 90
    :goto_0
    return-void

    .line 84
    :cond_0
    if-nez p1, :cond_1

    .line 85
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->titleText:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 87
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->titleText:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 88
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->titleText:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public showProgress()V
    .locals 2

    .prologue
    .line 108
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->rightButton:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 109
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->loadingProgressBar:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 110
    return-void
.end method
