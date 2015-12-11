.class public Lcom/aio/downloader/views/LDialogController;
.super Ljava/lang/Object;
.source "LDialogController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/LDialogController$ButtonHandler;,
        Lcom/aio/downloader/views/LDialogController$DialogParams;
    }
.end annotation


# instance fields
.field public centerMsg:Z

.field public clickPositiveBtnDismiss:Z

.field mButtonHandler:Landroid/view/View$OnClickListener;

.field private mButtonNegative:Lcom/aio/downloader/views/LButton;

.field private mButtonNegativeMessage:Landroid/os/Message;

.field private mButtonNegativeText:Ljava/lang/CharSequence;

.field private mButtonPositive:Lcom/aio/downloader/views/LButton;

.field private mButtonPositiveMessage:Landroid/os/Message;

.field private mButtonPositiveText:Ljava/lang/CharSequence;

.field public mCloseImageView:Lcom/aio/downloader/views/LImageButton;

.field private final mDialogInterface:Landroid/content/DialogInterface;

.field private mHandler:Landroid/os/Handler;

.field private mIcon:Landroid/graphics/drawable/Drawable;

.field private mIconId:I

.field private mIconView:Landroid/widget/ImageView;

.field private mMessage:Ljava/lang/CharSequence;

.field private mMessageView:Landroid/widget/TextView;

.field private mScrollView:Landroid/widget/ScrollView;

.field private mShowCloseBtn:Z

.field private mTitle:Ljava/lang/CharSequence;

.field private mTitleView:Landroid/widget/TextView;

.field private mView:Landroid/view/View;

.field private final mWindow:Landroid/view/Window;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/content/DialogInterface;Landroid/view/Window;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "di"    # Landroid/content/DialogInterface;
    .param p3, "window"    # Landroid/view/Window;

    .prologue
    .line 115
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    const/4 v0, -0x1

    iput v0, p0, Lcom/aio/downloader/views/LDialogController;->mIconId:I

    .line 59
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/views/LDialogController;->mShowCloseBtn:Z

    .line 65
    new-instance v0, Lcom/aio/downloader/views/LDialogController$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/views/LDialogController$1;-><init>(Lcom/aio/downloader/views/LDialogController;)V

    iput-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mButtonHandler:Landroid/view/View$OnClickListener;

    .line 116
    iput-object p2, p0, Lcom/aio/downloader/views/LDialogController;->mDialogInterface:Landroid/content/DialogInterface;

    .line 117
    iput-object p3, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    .line 118
    new-instance v0, Lcom/aio/downloader/views/LDialogController$ButtonHandler;

    invoke-direct {v0, p2}, Lcom/aio/downloader/views/LDialogController$ButtonHandler;-><init>(Landroid/content/DialogInterface;)V

    iput-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mHandler:Landroid/os/Handler;

    .line 119
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/LDialogController;)Lcom/aio/downloader/views/LButton;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositive:Lcom/aio/downloader/views/LButton;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/views/LDialogController;)Landroid/os/Message;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositiveMessage:Landroid/os/Message;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/views/LDialogController;)Lcom/aio/downloader/views/LButton;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegative:Lcom/aio/downloader/views/LButton;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/views/LDialogController;)Landroid/os/Message;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegativeMessage:Landroid/os/Message;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/views/LDialogController;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/views/LDialogController;)Landroid/content/DialogInterface;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mDialogInterface:Landroid/content/DialogInterface;

    return-object v0
.end method

.method private setupButtons()Z
    .locals 7

    .prologue
    const/16 v6, 0x8

    const/4 v4, 0x0

    .line 213
    const/4 v1, 0x1

    .line 214
    .local v1, "BIT_BUTTON_POSITIVE":I
    const/4 v0, 0x2

    .line 215
    .local v0, "BIT_BUTTON_NEGATIVE":I
    const/4 v2, 0x0

    .line 216
    .local v2, "whichButtons":I
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v5, 0x7f0702c4

    invoke-virtual {v3, v5}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/views/LButton;

    iput-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositive:Lcom/aio/downloader/views/LButton;

    .line 217
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositive:Lcom/aio/downloader/views/LButton;

    iget-object v5, p0, Lcom/aio/downloader/views/LDialogController;->mButtonHandler:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v5}, Lcom/aio/downloader/views/LButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 219
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositiveText:Ljava/lang/CharSequence;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 220
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositive:Lcom/aio/downloader/views/LButton;

    invoke-virtual {v3, v6}, Lcom/aio/downloader/views/LButton;->setVisibility(I)V

    .line 227
    :goto_0
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v5, 0x7f0702c3

    invoke-virtual {v3, v5}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/views/LButton;

    iput-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegative:Lcom/aio/downloader/views/LButton;

    .line 228
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegative:Lcom/aio/downloader/views/LButton;

    iget-object v5, p0, Lcom/aio/downloader/views/LDialogController;->mButtonHandler:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v5}, Lcom/aio/downloader/views/LButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 230
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegativeText:Ljava/lang/CharSequence;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 231
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegative:Lcom/aio/downloader/views/LButton;

    invoke-virtual {v3, v6}, Lcom/aio/downloader/views/LButton;->setVisibility(I)V

    .line 238
    :goto_1
    if-eqz v2, :cond_2

    const/4 v3, 0x1

    :goto_2
    return v3

    .line 222
    :cond_0
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositive:Lcom/aio/downloader/views/LButton;

    iget-object v5, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositiveText:Ljava/lang/CharSequence;

    invoke-virtual {v3, v5}, Lcom/aio/downloader/views/LButton;->setText(Ljava/lang/CharSequence;)V

    .line 223
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositive:Lcom/aio/downloader/views/LButton;

    invoke-virtual {v3, v4}, Lcom/aio/downloader/views/LButton;->setVisibility(I)V

    .line 224
    or-int/2addr v2, v1

    goto :goto_0

    .line 233
    :cond_1
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegative:Lcom/aio/downloader/views/LButton;

    iget-object v5, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegativeText:Ljava/lang/CharSequence;

    invoke-virtual {v3, v5}, Lcom/aio/downloader/views/LButton;->setText(Ljava/lang/CharSequence;)V

    .line 234
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegative:Lcom/aio/downloader/views/LButton;

    invoke-virtual {v3, v4}, Lcom/aio/downloader/views/LButton;->setVisibility(I)V

    .line 235
    or-int/2addr v2, v0

    goto :goto_1

    :cond_2
    move v3, v4

    .line 238
    goto :goto_2
.end method

.method private setupContent()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 192
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v1, 0x7f0702bf

    invoke-virtual {v0, v1}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    iput-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mScrollView:Landroid/widget/ScrollView;

    .line 193
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mScrollView:Landroid/widget/ScrollView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->setFocusable(Z)V

    .line 195
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v1, 0x7f0702c0

    invoke-virtual {v0, v1}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mMessageView:Landroid/widget/TextView;

    .line 196
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mMessage:Ljava/lang/CharSequence;

    if-eqz v0, :cond_1

    .line 197
    iget-boolean v0, p0, Lcom/aio/downloader/views/LDialogController;->centerMsg:Z

    if-eqz v0, :cond_0

    .line 198
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mMessageView:Landroid/widget/TextView;

    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 200
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mMessageView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController;->mMessage:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 205
    :goto_0
    return-void

    .line 202
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mMessageView:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 203
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mScrollView:Landroid/widget/ScrollView;

    invoke-virtual {v0, v2}, Landroid/widget/ScrollView;->setVisibility(I)V

    goto :goto_0
.end method

.method private setupTitle()Z
    .locals 10

    .prologue
    const/4 v4, 0x0

    const/16 v5, 0x8

    .line 149
    const/4 v1, 0x1

    .line 151
    .local v1, "hasTitle":Z
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mTitle:Ljava/lang/CharSequence;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    move v0, v4

    .line 152
    .local v0, "hasTextTitle":Z
    :goto_0
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v6, 0x7f0702bc

    invoke-virtual {v3, v6}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    .line 153
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v6, 0x7f0701ea

    invoke-virtual {v3, v6}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/views/LImageButton;

    iput-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mCloseImageView:Lcom/aio/downloader/views/LImageButton;

    .line 154
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mCloseImageView:Lcom/aio/downloader/views/LImageButton;

    new-instance v6, Lcom/aio/downloader/views/LDialogController$2;

    invoke-direct {v6, p0}, Lcom/aio/downloader/views/LDialogController$2;-><init>(Lcom/aio/downloader/views/LDialogController;)V

    invoke-virtual {v3, v6}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 161
    if-eqz v0, :cond_6

    .line 162
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v6, 0x7f0702bd

    invoke-virtual {v3, v6}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mTitleView:Landroid/widget/TextView;

    .line 163
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mTitleView:Landroid/widget/TextView;

    iget-object v6, p0, Lcom/aio/downloader/views/LDialogController;->mTitle:Ljava/lang/CharSequence;

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 164
    iget v3, p0, Lcom/aio/downloader/views/LDialogController;->mIconId:I

    if-lez v3, :cond_3

    .line 165
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    iget v6, p0, Lcom/aio/downloader/views/LDialogController;->mIconId:I

    invoke-virtual {v3, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 174
    :cond_0
    :goto_1
    iget-object v6, p0, Lcom/aio/downloader/views/LDialogController;->mCloseImageView:Lcom/aio/downloader/views/LImageButton;

    iget-boolean v3, p0, Lcom/aio/downloader/views/LDialogController;->mShowCloseBtn:Z

    if-eqz v3, :cond_5

    move v3, v4

    :goto_2
    invoke-virtual {v6, v3}, Lcom/aio/downloader/views/LImageButton;->setVisibility(I)V

    .line 185
    :goto_3
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v6, 0x7f0702be

    invoke-virtual {v3, v6}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 186
    if-eqz v1, :cond_1

    move v4, v5

    .line 185
    :cond_1
    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 187
    return v1

    .line 151
    .end local v0    # "hasTextTitle":Z
    :cond_2
    const/4 v0, 0x1

    goto :goto_0

    .line 166
    .restart local v0    # "hasTextTitle":Z
    :cond_3
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mIcon:Landroid/graphics/drawable/Drawable;

    if-eqz v3, :cond_4

    .line 167
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    iget-object v6, p0, Lcom/aio/downloader/views/LDialogController;->mIcon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 168
    :cond_4
    iget v3, p0, Lcom/aio/downloader/views/LDialogController;->mIconId:I

    if-nez v3, :cond_0

    .line 169
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mTitleView:Landroid/widget/TextView;

    iget-object v6, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    invoke-virtual {v6}, Landroid/widget/ImageView;->getPaddingLeft()I

    move-result v6

    .line 170
    iget-object v7, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    invoke-virtual {v7}, Landroid/widget/ImageView;->getPaddingTop()I

    move-result v7

    iget-object v8, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    invoke-virtual {v8}, Landroid/widget/ImageView;->getPaddingRight()I

    move-result v8

    .line 171
    iget-object v9, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    invoke-virtual {v9}, Landroid/widget/ImageView;->getPaddingBottom()I

    move-result v9

    .line 169
    invoke-virtual {v3, v6, v7, v8, v9}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 172
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    invoke-virtual {v3, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1

    .line 175
    :cond_5
    const/4 v3, 0x4

    goto :goto_2

    .line 178
    :cond_6
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v6, 0x7f0702bb

    invoke-virtual {v3, v6}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 179
    .local v2, "titleTemplate":Landroid/view/View;
    invoke-virtual {v2, v5}, Landroid/view/View;->setVisibility(I)V

    .line 180
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    invoke-virtual {v3, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 181
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v6, 0x7f0702ba

    invoke-virtual {v3, v6}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/view/View;->setVisibility(I)V

    .line 182
    const/4 v1, 0x0

    goto :goto_3
.end method

.method private setupView()V
    .locals 6

    .prologue
    const/16 v3, 0x8

    const/4 v5, -0x1

    .line 134
    invoke-direct {p0}, Lcom/aio/downloader/views/LDialogController;->setupContent()V

    .line 135
    invoke-direct {p0}, Lcom/aio/downloader/views/LDialogController;->setupButtons()Z

    move-result v1

    .line 136
    .local v1, "hasButtons":Z
    iget-object v2, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v4, 0x7f0702c2

    invoke-virtual {v2, v4}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 137
    if-eqz v1, :cond_0

    const/4 v2, 0x0

    .line 136
    :goto_0
    invoke-virtual {v4, v2}, Landroid/view/View;->setVisibility(I)V

    .line 138
    invoke-direct {p0}, Lcom/aio/downloader/views/LDialogController;->setupTitle()Z

    .line 139
    iget-object v2, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v4, 0x7f0702c1

    invoke-virtual {v2, v4}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 140
    .local v0, "custom":Landroid/widget/FrameLayout;
    iget-object v2, p0, Lcom/aio/downloader/views/LDialogController;->mView:Landroid/view/View;

    if-eqz v2, :cond_1

    .line 141
    iget-object v2, p0, Lcom/aio/downloader/views/LDialogController;->mView:Landroid/view/View;

    new-instance v3, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v3, v5, v5}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v2, v3}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 146
    :goto_1
    return-void

    .end local v0    # "custom":Landroid/widget/FrameLayout;
    :cond_0
    move v2, v3

    .line 137
    goto :goto_0

    .line 143
    .restart local v0    # "custom":Landroid/widget/FrameLayout;
    :cond_1
    invoke-virtual {v0, v3}, Landroid/widget/FrameLayout;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method public getDialogInterface()Landroid/content/DialogInterface;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mDialogInterface:Landroid/content/DialogInterface;

    return-object v0
.end method

.method public getMaxListLineNum()I
    .locals 1

    .prologue
    .line 208
    const/4 v0, 0x6

    return v0
.end method

.method public installContent()V
    .locals 2

    .prologue
    .line 128
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/Window;->requestFeature(I)Z

    .line 129
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mWindow:Landroid/view/Window;

    const v1, 0x7f030071

    invoke-virtual {v0, v1}, Landroid/view/Window;->setContentView(I)V

    .line 130
    invoke-direct {p0}, Lcom/aio/downloader/views/LDialogController;->setupView()V

    .line 131
    return-void
.end method

.method public setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Landroid/os/Message;)V
    .locals 1
    .param p1, "whichButton"    # I
    .param p2, "text"    # Ljava/lang/CharSequence;
    .param p3, "listener"    # Landroid/content/DialogInterface$OnClickListener;
    .param p4, "msg"    # Landroid/os/Message;

    .prologue
    .line 267
    if-nez p4, :cond_0

    if-eqz p3, :cond_0

    .line 268
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, p1, p3}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object p4

    .line 271
    :cond_0
    packed-switch p1, :pswitch_data_0

    .line 287
    :goto_0
    return-void

    .line 274
    :pswitch_0
    iput-object p2, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositiveText:Ljava/lang/CharSequence;

    .line 275
    iput-object p4, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositiveMessage:Landroid/os/Message;

    goto :goto_0

    .line 279
    :pswitch_1
    iput-object p2, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegativeText:Ljava/lang/CharSequence;

    .line 280
    iput-object p4, p0, Lcom/aio/downloader/views/LDialogController;->mButtonNegativeMessage:Landroid/os/Message;

    goto :goto_0

    .line 271
    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public setCenterMsg(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 254
    iput-boolean p1, p0, Lcom/aio/downloader/views/LDialogController;->centerMsg:Z

    .line 255
    return-void
.end method

.method public setClickPositiveBtnDismiss(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 250
    iput-boolean p1, p0, Lcom/aio/downloader/views/LDialogController;->clickPositiveBtnDismiss:Z

    .line 251
    return-void
.end method

.method public setCloseButton(Z)V
    .locals 0
    .param p1, "showCloseBtn"    # Z

    .prologue
    .line 290
    iput-boolean p1, p0, Lcom/aio/downloader/views/LDialogController;->mShowCloseBtn:Z

    .line 291
    return-void
.end method

.method public setIcon(I)V
    .locals 2
    .param p1, "resId"    # I

    .prologue
    .line 294
    iput p1, p0, Lcom/aio/downloader/views/LDialogController;->mIconId:I

    .line 295
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 296
    if-lez p1, :cond_1

    .line 297
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    iget v1, p0, Lcom/aio/downloader/views/LDialogController;->mIconId:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 302
    :cond_0
    :goto_0
    return-void

    .line 298
    :cond_1
    if-nez p1, :cond_0

    .line 299
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 305
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogController;->mIcon:Landroid/graphics/drawable/Drawable;

    .line 306
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mIcon:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 307
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mIconView:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 309
    :cond_0
    return-void
.end method

.method public setMessage(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/CharSequence;

    .prologue
    .line 258
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogController;->mMessage:Ljava/lang/CharSequence;

    .line 259
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mMessageView:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 260
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mMessageView:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 262
    :cond_0
    return-void
.end method

.method public setPositiveButtonEnable(Z)V
    .locals 1
    .param p1, "enable"    # Z

    .prologue
    .line 122
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mButtonPositive:Lcom/aio/downloader/views/LButton;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/LButton;->setEnabled(Z)V

    .line 123
    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 243
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogController;->mTitle:Ljava/lang/CharSequence;

    .line 244
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mTitleView:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 245
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController;->mTitleView:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 247
    :cond_0
    return-void
.end method

.method public setView(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 312
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogController;->mView:Landroid/view/View;

    .line 313
    return-void
.end method
