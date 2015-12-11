.class public final Lcom/wishabi/flipp/app/fr;
.super Lcom/wishabi/flipp/app/dl;
.source "SourceFile"


# instance fields
.field private a:Landroid/widget/VideoView;

.field private c:Landroid/widget/ProgressBar;

.field private d:Landroid/widget/TextView;

.field private e:Landroid/widget/MediaController;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/wishabi/flipp/app/dl;-><init>()V

    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2

    .prologue
    .line 24
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 25
    const-string v1, "SAVE_STATE_TITLE_KEY"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    const-string v1, "SAVE_STATE_URL_KEY"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/fr;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/wishabi/flipp/app/fr;->c:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method public static a(Landroid/os/Bundle;)Lcom/wishabi/flipp/app/fr;
    .locals 1

    .prologue
    .line 36
    new-instance v0, Lcom/wishabi/flipp/app/fr;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/fr;-><init>()V

    .line 37
    invoke-virtual {v0, p0}, Lcom/wishabi/flipp/app/fr;->setArguments(Landroid/os/Bundle;)V

    .line 39
    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/fr;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/wishabi/flipp/app/fr;->d:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/fr;)Landroid/widget/MediaController;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/wishabi/flipp/app/fr;->e:Landroid/widget/MediaController;

    return-object v0
.end method


# virtual methods
.method public final onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 58
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onCreate(Landroid/os/Bundle;)V

    .line 60
    if-eqz p1, :cond_1

    .line 63
    :goto_0
    if-eqz p1, :cond_0

    .line 64
    const-string v0, "SAVE_STATE_TITLE_KEY"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/fr;->f:Ljava/lang/String;

    .line 65
    const-string v0, "SAVE_STATE_URL_KEY"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/fr;->g:Ljava/lang/String;

    .line 67
    :cond_0
    return-void

    .line 60
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/fr;->getArguments()Landroid/os/Bundle;

    move-result-object p1

    goto :goto_0
.end method

.method public final onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 73
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/fr;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 74
    if-nez v2, :cond_0

    .line 75
    invoke-super {p0, p1, p2, p3}, Lcom/wishabi/flipp/app/dl;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 107
    :goto_0
    return-object v0

    .line 77
    :cond_0
    const v0, 0x7f030055

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 78
    if-nez v1, :cond_1

    .line 79
    invoke-super {p0, p1, p2, p3}, Lcom/wishabi/flipp/app/dl;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    goto :goto_0

    .line 81
    :cond_1
    const v0, 0x7f0b0148

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/VideoView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/fr;->a:Landroid/widget/VideoView;

    .line 82
    const v0, 0x7f0b0149

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/wishabi/flipp/app/fr;->c:Landroid/widget/ProgressBar;

    .line 83
    const v0, 0x7f0b014a

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/fr;->d:Landroid/widget/TextView;

    .line 85
    new-instance v0, Landroid/widget/MediaController;

    invoke-direct {v0, v2}, Landroid/widget/MediaController;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/fr;->e:Landroid/widget/MediaController;

    .line 87
    iget-object v0, p0, Lcom/wishabi/flipp/app/fr;->a:Landroid/widget/VideoView;

    iget-object v2, p0, Lcom/wishabi/flipp/app/fr;->e:Landroid/widget/MediaController;

    invoke-virtual {v0, v2}, Landroid/widget/VideoView;->setMediaController(Landroid/widget/MediaController;)V

    .line 88
    iget-object v0, p0, Lcom/wishabi/flipp/app/fr;->a:Landroid/widget/VideoView;

    new-instance v2, Lcom/wishabi/flipp/app/fs;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/fs;-><init>(Lcom/wishabi/flipp/app/fr;)V

    invoke-virtual {v0, v2}, Landroid/widget/VideoView;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 97
    new-instance v0, Lcom/wishabi/flipp/app/ft;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/ft;-><init>(Lcom/wishabi/flipp/app/fr;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    move-object v0, v1

    .line 107
    goto :goto_0
.end method

.method public final onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 122
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 124
    const-string v0, "SAVE_STATE_TITLE_KEY"

    iget-object v1, p0, Lcom/wishabi/flipp/app/fr;->f:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string v0, "SAVE_STATE_URL_KEY"

    iget-object v1, p0, Lcom/wishabi/flipp/app/fr;->g:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    return-void
.end method

.method public final onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 112
    invoke-super {p0, p1, p2}, Lcom/wishabi/flipp/app/dl;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 114
    iget-object v0, p0, Lcom/wishabi/flipp/app/fr;->a:Landroid/widget/VideoView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/fr;->g:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setVideoURI(Landroid/net/Uri;)V

    .line 115
    iget-object v0, p0, Lcom/wishabi/flipp/app/fr;->a:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->start()V

    .line 117
    iget-object v0, p0, Lcom/wishabi/flipp/app/fr;->f:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/fr;->b(Ljava/lang/String;)V

    .line 118
    return-void
.end method
