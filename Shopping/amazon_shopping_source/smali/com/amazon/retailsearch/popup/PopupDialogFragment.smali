.class public Lcom/amazon/retailsearch/popup/PopupDialogFragment;
.super Landroid/app/DialogFragment;
.source "PopupDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/popup/PopupDialogFragment$4;,
        Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;,
        Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;,
        Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnCloseListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<PopupView:",
        "Landroid/view/View;",
        ":",
        "Lcom/amazon/retailsearch/popup/PopupDialog;",
        ">",
        "Landroid/app/DialogFragment;"
    }
.end annotation


# static fields
.field public static final DIALOG_TAG:Ljava/lang/String; = "popup_dialog_fragment"

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private childSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/retailsearch/popup/PopupDialogFragment",
            "<TPopupView;>.ChildSizeChanged",
            "Listener;"
        }
    .end annotation
.end field

.field private dialog:Landroid/app/Dialog;

.field private height:I

.field private mAnchorId:I

.field private mCloseListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnCloseListener;

.field private mContent:Landroid/view/View;

.field private mPosition:Lcom/amazon/retailsearch/popup/Position;

.field private mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;

.field private mXOffset:I

.field private mYOffset:I

.field private maxHeight:I

.field private width:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    const-class v0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 39
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    .line 49
    new-instance v0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;-><init>(Lcom/amazon/retailsearch/popup/PopupDialogFragment;Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->childSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;

    .line 302
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/popup/PopupDialogFragment;Landroid/app/Dialog;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragment;
    .param p1, "x1"    # Landroid/app/Dialog;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->setDialogBounds(Landroid/app/Dialog;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)Landroid/app/Dialog;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    .prologue
    .line 39
    iget v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->maxHeight:I

    return v0
.end method

.method static synthetic access$402(Lcom/amazon/retailsearch/popup/PopupDialogFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragment;
    .param p1, "x1"    # I

    .prologue
    .line 39
    iput p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->height:I

    return p1
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;

    return-object v0
.end method

.method private setDialogBounds(Landroid/app/Dialog;)V
    .locals 9
    .param p1, "dialog"    # Landroid/app/Dialog;

    .prologue
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    const/4 v8, 0x0

    .line 241
    const/4 v2, 0x0

    .line 242
    .local v2, "anchorWidth":I
    const/4 v1, 0x0

    .line 243
    .local v1, "anchorHeight":I
    const/4 v6, 0x2

    new-array v4, v6, [I

    .line 245
    .local v4, "location":[I
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->getAnchor()Landroid/view/View;

    move-result-object v0

    .line 246
    .local v0, "anchor":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 248
    invoke-virtual {v0, v4}, Landroid/view/View;->getLocationInWindow([I)V

    .line 249
    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v2

    .line 250
    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v1

    .line 253
    :cond_0
    invoke-virtual {p1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v5

    .line 254
    .local v5, "params":Landroid/view/WindowManager$LayoutParams;
    const/4 v6, 0x1

    aget v6, v4, v6

    add-int/2addr v6, v1

    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 256
    sget-object v6, Lcom/amazon/retailsearch/popup/PopupDialogFragment$4;->$SwitchMap$com$amazon$retailsearch$popup$Position:[I

    iget-object v7, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mPosition:Lcom/amazon/retailsearch/popup/Position;

    invoke-virtual {v7}, Lcom/amazon/retailsearch/popup/Position;->ordinal()I

    move-result v7

    aget v6, v6, v7

    packed-switch v6, :pswitch_data_0

    .line 265
    :goto_0
    iget v6, v5, Landroid/view/WindowManager$LayoutParams;->x:I

    iget v7, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mXOffset:I

    add-int/2addr v6, v7

    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 266
    iget v6, v5, Landroid/view/WindowManager$LayoutParams;->y:I

    iget v7, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mYOffset:I

    add-int/2addr v6, v7

    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 268
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v3

    .line 269
    .local v3, "decorView":Landroid/view/View;
    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->width:I

    if-nez v6, :cond_2

    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v6

    :goto_1
    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 270
    invoke-virtual {v3}, Landroid/view/View;->getHeight()I

    move-result v6

    iget v7, v5, Landroid/view/WindowManager$LayoutParams;->y:I

    sub-int/2addr v6, v7

    iput v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->maxHeight:I

    .line 271
    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->height:I

    if-lez v6, :cond_3

    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->height:I

    iget v7, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->maxHeight:I

    if-ge v6, v7, :cond_3

    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->height:I

    :goto_2
    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->height:I

    .line 273
    invoke-virtual {p1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6, v5}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 275
    iget-object v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;

    if-eqz v6, :cond_1

    .line 276
    iget-object v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;

    invoke-interface {v6}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;->onSizeChanged()V

    .line 278
    :cond_1
    return-void

    .line 258
    .end local v3    # "decorView":Landroid/view/View;
    :pswitch_0
    aget v6, v4, v8

    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->x:I

    goto :goto_0

    .line 261
    :pswitch_1
    aget v6, v4, v8

    iget v7, v5, Landroid/view/WindowManager$LayoutParams;->width:I

    div-int/lit8 v7, v7, 0x2

    int-to-float v7, v7

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v7

    sub-int/2addr v6, v7

    div-int/lit8 v7, v2, 0x2

    int-to-float v7, v7

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v7

    add-int/2addr v6, v7

    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->x:I

    goto :goto_0

    .line 269
    .restart local v3    # "decorView":Landroid/view/View;
    :cond_2
    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->width:I

    goto :goto_1

    .line 271
    :cond_3
    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->maxHeight:I

    goto :goto_2

    .line 256
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public getAnchor()Landroid/view/View;
    .locals 2

    .prologue
    .line 207
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    iget v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mAnchorId:I

    invoke-virtual {v0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    return-object v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 225
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->getAnchor()Landroid/view/View;

    move-result-object v0

    .line 226
    .local v0, "anchor":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 229
    new-instance v1, Lcom/amazon/retailsearch/popup/PopupDialogFragment$2;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$2;-><init>(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->runAfterNextLayoutPass(Landroid/view/View;Ljava/lang/Runnable;)V

    .line 238
    :cond_0
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    const/4 v5, 0x1

    const/4 v4, -0x2

    .line 128
    new-instance v1, Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const v3, 0x1030010

    invoke-direct {v1, p0, v2, v3}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;-><init>(Lcom/amazon/retailsearch/popup/PopupDialogFragment;Landroid/content/Context;I)V

    iput-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;

    .line 154
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->getAnchor()Landroid/view/View;

    move-result-object v1

    if-nez v1, :cond_0

    .line 157
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dismiss()V

    .line 158
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;

    .line 174
    :goto_0
    return-object v1

    .line 163
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;

    invoke-virtual {v1, v5}, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V

    .line 164
    invoke-virtual {p0, v5}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->setCancelable(Z)V

    .line 166
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;

    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/16 v2, 0x400

    invoke-virtual {v1, v2}, Landroid/view/Window;->clearFlags(I)V

    .line 167
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;

    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v4, v4}, Landroid/view/Window;->setLayout(II)V

    .line 168
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;

    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/16 v2, 0x33

    invoke-virtual {v1, v2}, Landroid/view/Window;->setGravity(I)V

    .line 170
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;

    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 171
    .local v0, "params":Landroid/view/WindowManager$LayoutParams;
    sget v1, Lcom/amazon/retailsearch/R$style;->PopupDialogFragmentAnimation:I

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    .line 172
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->setDialogBounds(Landroid/app/Dialog;)V

    .line 174
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 181
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 182
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 185
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    return-object v0
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    .line 190
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    invoke-super {p0}, Landroid/app/DialogFragment;->onDestroyView()V

    .line 192
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mCloseListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnCloseListener;

    if-eqz v0, :cond_0

    .line 193
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mCloseListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnCloseListener;

    invoke-interface {v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnCloseListener;->onClose()V

    .line 196
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 197
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 198
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 201
    :cond_1
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mAnchorId:I

    .line 202
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    .line 204
    :cond_2
    return-void
.end method

.method public runAfterNextLayoutPass(Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "runnable"    # Ljava/lang/Runnable;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 284
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    invoke-virtual {p1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    new-instance v1, Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;-><init>(Lcom/amazon/retailsearch/popup/PopupDialogFragment;Landroid/view/View;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 295
    return-void
.end method

.method public setOnCloseListener(Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnCloseListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnCloseListener;

    .prologue
    .line 66
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mCloseListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnCloseListener;

    .line 67
    return-void
.end method

.method public setOnSizeChangedListener(Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;

    .prologue
    .line 70
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;

    .line 71
    return-void
.end method

.method public setPosition(Lcom/amazon/retailsearch/popup/Position;)V
    .locals 1
    .param p1, "position"    # Lcom/amazon/retailsearch/popup/Position;

    .prologue
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    const/4 v0, 0x0

    .line 211
    invoke-virtual {p0, p1, v0, v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->setPosition(Lcom/amazon/retailsearch/popup/Position;II)V

    .line 212
    return-void
.end method

.method public setPosition(Lcom/amazon/retailsearch/popup/Position;II)V
    .locals 1
    .param p1, "position"    # Lcom/amazon/retailsearch/popup/Position;
    .param p2, "xOffset"    # I
    .param p3, "yOffset"    # I

    .prologue
    .line 215
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 216
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mPosition:Lcom/amazon/retailsearch/popup/Position;

    .line 217
    iput p2, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mXOffset:I

    .line 218
    iput p3, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mYOffset:I

    .line 219
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->setDialogBounds(Landroid/app/Dialog;)V

    .line 221
    :cond_0
    return-void
.end method

.method public show(Landroid/app/FragmentManager;ILandroid/view/View;Lcom/amazon/retailsearch/popup/Position;II)V
    .locals 9
    .param p1, "manager"    # Landroid/app/FragmentManager;
    .param p2, "anchorId"    # I
    .param p4, "position"    # Lcom/amazon/retailsearch/popup/Position;
    .param p5, "width"    # I
    .param p6, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/FragmentManager;",
            "ITPopupView;",
            "Lcom/amazon/retailsearch/popup/Position;",
            "II)V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    .local p3, "content":Landroid/view/View;, "TPopupView;"
    const/4 v5, 0x0

    .line 83
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    move v6, v5

    move v7, p5

    move v8, p6

    invoke-virtual/range {v0 .. v8}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->show(Landroid/app/FragmentManager;ILandroid/view/View;Lcom/amazon/retailsearch/popup/Position;IIII)V

    .line 84
    return-void
.end method

.method public show(Landroid/app/FragmentManager;ILandroid/view/View;Lcom/amazon/retailsearch/popup/Position;IIII)V
    .locals 4
    .param p1, "manager"    # Landroid/app/FragmentManager;
    .param p2, "anchorId"    # I
    .param p4, "position"    # Lcom/amazon/retailsearch/popup/Position;
    .param p5, "xOffset"    # I
    .param p6, "yOffset"    # I
    .param p7, "width"    # I
    .param p8, "height"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/FragmentManager;",
            "ITPopupView;",
            "Lcom/amazon/retailsearch/popup/Position;",
            "IIII)V"
        }
    .end annotation

    .prologue
    .line 99
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>;"
    .local p3, "content":Landroid/view/View;, "TPopupView;"
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 124
    .end local p3    # "content":Landroid/view/View;, "TPopupView;"
    :goto_0
    return-void

    .line 103
    .restart local p3    # "content":Landroid/view/View;, "TPopupView;"
    :cond_0
    iput p2, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mAnchorId:I

    .line 104
    iput-object p3, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mContent:Landroid/view/View;

    .line 105
    iput-object p4, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mPosition:Lcom/amazon/retailsearch/popup/Position;

    .line 106
    iput p5, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mXOffset:I

    .line 107
    iput p6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mYOffset:I

    .line 108
    iput p7, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->width:I

    .line 109
    iput p8, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->height:I

    .line 111
    check-cast p3, Lcom/amazon/retailsearch/popup/PopupDialog;

    .end local p3    # "content":Landroid/view/View;, "TPopupView;"
    iget-object v2, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->childSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;

    invoke-interface {p3, v2}, Lcom/amazon/retailsearch/popup/PopupDialog;->setSizeChangeListener(Lcom/amazon/retailsearch/popup/DialogSizeChangedListener;)V

    .line 114
    :try_start_0
    invoke-virtual {p1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 116
    .local v1, "transaction":Landroid/app/FragmentTransaction;
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->isAddToBackStackAllowed()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 117
    const-string/jumbo v2, "popup_dialog_fragment"

    invoke-virtual {v1, v2}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 120
    :cond_1
    const-string/jumbo v2, "popup_dialog_fragment"

    invoke-virtual {p0, v1, v2}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->show(Landroid/app/FragmentTransaction;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 121
    .end local v1    # "transaction":Landroid/app/FragmentTransaction;
    :catch_0
    move-exception v0

    .line 122
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v3, "Error while displaying popup dialog fragment"

    invoke-interface {v2, v3, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
