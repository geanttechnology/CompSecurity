.class public final Lcom/wishabi/flipp/app/fn;
.super Lcom/wishabi/flipp/app/dp;
.source "SourceFile"


# instance fields
.field private b:Lcom/wishabi/flipp/content/FormattedString;

.field private c:I

.field private d:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/wishabi/flipp/app/dp;-><init>()V

    return-void
.end method

.method public static a(Lcom/wishabi/flipp/content/FormattedString;II)Lcom/wishabi/flipp/app/fn;
    .locals 2

    .prologue
    .line 23
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 24
    const-string v1, "SAVE_STATE_DESCRIPTION_KEY"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 25
    const-string v1, "SAVE_STATE_IMAGE_ID_KEY"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 26
    const-string v1, "SAVE_STATE_BACKGROUND_RES_ID_KEY"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 28
    new-instance v1, Lcom/wishabi/flipp/app/fn;

    invoke-direct {v1}, Lcom/wishabi/flipp/app/fn;-><init>()V

    .line 29
    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/app/fn;->setArguments(Landroid/os/Bundle;)V

    .line 31
    return-object v1
.end method


# virtual methods
.method public final onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 47
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dp;->onCreate(Landroid/os/Bundle;)V

    .line 49
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/fn;->getArguments()Landroid/os/Bundle;

    move-result-object p1

    .line 51
    :cond_0
    if-nez p1, :cond_1

    .line 52
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/fn;->b:Lcom/wishabi/flipp/content/FormattedString;

    .line 53
    iput v1, p0, Lcom/wishabi/flipp/app/fn;->c:I

    .line 54
    iput v1, p0, Lcom/wishabi/flipp/app/fn;->d:I

    .line 60
    :goto_0
    return-void

    .line 56
    :cond_1
    const-string v0, "SAVE_STATE_DESCRIPTION_KEY"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/FormattedString;

    iput-object v0, p0, Lcom/wishabi/flipp/app/fn;->b:Lcom/wishabi/flipp/content/FormattedString;

    .line 57
    const-string v0, "SAVE_STATE_IMAGE_ID_KEY"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/fn;->c:I

    .line 58
    const-string v0, "SAVE_STATE_BACKGROUND_RES_ID_KEY"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/fn;->d:I

    goto :goto_0
.end method

.method public final onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 3

    .prologue
    .line 98
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dp;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;

    move-result-object v0

    .line 99
    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/view/Window;->requestFeature(I)Z

    .line 100
    iget v1, p0, Lcom/wishabi/flipp/app/fn;->d:I

    if-eqz v1, :cond_0

    .line 101
    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    iget v2, p0, Lcom/wishabi/flipp/app/fn;->d:I

    invoke-virtual {v1, v2}, Landroid/view/Window;->setBackgroundDrawableResource(I)V

    .line 102
    :cond_0
    return-object v0
.end method

.method public final onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 66
    invoke-super {p0, p1, p2, p3}, Lcom/wishabi/flipp/app/dp;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 68
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/fn;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 69
    if-nez v1, :cond_1

    .line 93
    :cond_0
    :goto_0
    return-object v0

    .line 72
    :cond_1
    const v1, 0x7f030054

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 74
    if-eqz v1, :cond_0

    .line 77
    const v0, 0x7f0b0146

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 78
    iget-object v2, p0, Lcom/wishabi/flipp/app/fn;->b:Lcom/wishabi/flipp/content/FormattedString;

    if-eqz v2, :cond_2

    .line 79
    iget-object v2, p0, Lcom/wishabi/flipp/app/fn;->b:Lcom/wishabi/flipp/content/FormattedString;

    invoke-virtual {v2}, Lcom/wishabi/flipp/content/FormattedString;->a()Landroid/text/Spannable;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 81
    :cond_2
    const v0, 0x7f0b0145

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 82
    iget v2, p0, Lcom/wishabi/flipp/app/fn;->c:I

    if-eqz v2, :cond_3

    .line 83
    iget v2, p0, Lcom/wishabi/flipp/app/fn;->c:I

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 85
    :cond_3
    const v0, 0x7f0b0147

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 86
    new-instance v2, Lcom/wishabi/flipp/app/fo;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/fo;-><init>(Lcom/wishabi/flipp/app/fn;)V

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    move-object v0, v1

    .line 93
    goto :goto_0
.end method

.method public final onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 107
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dp;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 108
    const-string v0, "SAVE_STATE_DESCRIPTION_KEY"

    iget-object v1, p0, Lcom/wishabi/flipp/app/fn;->b:Lcom/wishabi/flipp/content/FormattedString;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 109
    const-string v0, "SAVE_STATE_IMAGE_ID_KEY"

    iget v1, p0, Lcom/wishabi/flipp/app/fn;->c:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 110
    const-string v0, "SAVE_STATE_BACKGROUND_RES_ID_KEY"

    iget v1, p0, Lcom/wishabi/flipp/app/fn;->d:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 111
    return-void
.end method
