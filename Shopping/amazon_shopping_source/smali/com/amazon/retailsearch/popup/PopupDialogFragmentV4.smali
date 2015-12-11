.class public Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;
.super Landroid/support/v4/app/DialogFragment;
.source "PopupDialogFragmentV4.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$4;,
        Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;,
        Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;,
        Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnCloseListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<PopupView:",
        "Landroid/view/View;",
        ":",
        "Lcom/amazon/retailsearch/popup/PopupDialog;",
        ">",
        "Landroid/support/v4/app/DialogFragment;"
    }
.end annotation


# static fields
.field public static final DIALOG_TAG:Ljava/lang/String; = "popup_dialog_fragment"

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private childSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4",
            "<TPopupView;>.ChildSizeChanged",
            "Listener;"
        }
    .end annotation
.end field

.field private dialog:Landroid/app/Dialog;

.field private height:I

.field private mAnchorId:I

.field private mCloseListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnCloseListener;

.field private mContent:Landroid/view/View;

.field private mPosition:Lcom/amazon/retailsearch/popup/Position;

.field private mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;

.field private mXOffset:I

.field private mYOffset:I

.field private maxHeight:I

.field private width:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const-class v0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 38
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    .line 48
    new-instance v0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;-><init>(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->childSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;

    .line 299
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;Landroid/app/Dialog;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;
    .param p1, "x1"    # Landroid/app/Dialog;

    .prologue
    .line 38
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->setDialogBounds(Landroid/app/Dialog;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)Landroid/app/Dialog;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->dialog:Landroid/app/Dialog;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    .prologue
    .line 38
    iget v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->maxHeight:I

    return v0
.end method

.method static synthetic access$402(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;
    .param p1, "x1"    # I

    .prologue
    .line 38
    iput p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->height:I

    return p1
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;

    return-object v0
.end method

.method private setDialogBounds(Landroid/app/Dialog;)V
    .locals 9
    .param p1, "dialog"    # Landroid/app/Dialog;

    .prologue
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    const/4 v8, 0x0

    .line 238
    const/4 v2, 0x0

    .line 239
    .local v2, "anchorWidth":I
    const/4 v1, 0x0

    .line 240
    .local v1, "anchorHeight":I
    const/4 v6, 0x2

    new-array v4, v6, [I

    .line 242
    .local v4, "location":[I
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->getAnchor()Landroid/view/View;

    move-result-object v0

    .line 243
    .local v0, "anchor":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 245
    invoke-virtual {v0, v4}, Landroid/view/View;->getLocationInWindow([I)V

    .line 246
    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v2

    .line 247
    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v1

    .line 250
    :cond_0
    invoke-virtual {p1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v5

    .line 251
    .local v5, "params":Landroid/view/WindowManager$LayoutParams;
    const/4 v6, 0x1

    aget v6, v4, v6

    add-int/2addr v6, v1

    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 253
    sget-object v6, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$4;->$SwitchMap$com$amazon$retailsearch$popup$Position:[I

    iget-object v7, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mPosition:Lcom/amazon/retailsearch/popup/Position;

    invoke-virtual {v7}, Lcom/amazon/retailsearch/popup/Position;->ordinal()I

    move-result v7

    aget v6, v6, v7

    packed-switch v6, :pswitch_data_0

    .line 262
    :goto_0
    iget v6, v5, Landroid/view/WindowManager$LayoutParams;->x:I

    iget v7, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mXOffset:I

    add-int/2addr v6, v7

    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 263
    iget v6, v5, Landroid/view/WindowManager$LayoutParams;->y:I

    iget v7, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mYOffset:I

    add-int/2addr v6, v7

    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 265
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v3

    .line 266
    .local v3, "decorView":Landroid/view/View;
    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->width:I

    if-nez v6, :cond_2

    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v6

    :goto_1
    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 267
    invoke-virtual {v3}, Landroid/view/View;->getHeight()I

    move-result v6

    iget v7, v5, Landroid/view/WindowManager$LayoutParams;->y:I

    sub-int/2addr v6, v7

    iput v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->maxHeight:I

    .line 268
    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->height:I

    if-lez v6, :cond_3

    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->height:I

    iget v7, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->maxHeight:I

    if-ge v6, v7, :cond_3

    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->height:I

    :goto_2
    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->height:I

    .line 270
    invoke-virtual {p1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6, v5}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 272
    iget-object v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;

    if-eqz v6, :cond_1

    .line 273
    iget-object v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;

    invoke-interface {v6}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;->onSizeChanged()V

    .line 275
    :cond_1
    return-void

    .line 255
    .end local v3    # "decorView":Landroid/view/View;
    :pswitch_0
    aget v6, v4, v8

    iput v6, v5, Landroid/view/WindowManager$LayoutParams;->x:I

    goto :goto_0

    .line 258
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

    .line 266
    .restart local v3    # "decorView":Landroid/view/View;
    :cond_2
    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->width:I

    goto :goto_1

    .line 268
    :cond_3
    iget v6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->maxHeight:I

    goto :goto_2

    .line 253
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
    .line 204
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mAnchorId:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    return-object v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 222
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->getAnchor()Landroid/view/View;

    move-result-object v0

    .line 223
    .local v0, "anchor":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 226
    new-instance v1, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$2;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$2;-><init>(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)V

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->runAfterNextLayoutPass(Landroid/view/View;Ljava/lang/Runnable;)V

    .line 235
    :cond_0
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    const/4 v5, 0x1

    const/4 v4, -0x2

    .line 125
    new-instance v0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$1;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x1030010

    invoke-direct {v0, p0, v2, v3}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$1;-><init>(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;Landroid/content/Context;I)V

    .line 151
    .local v0, "dialog":Landroid/app/Dialog;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->getAnchor()Landroid/view/View;

    move-result-object v2

    if-nez v2, :cond_0

    .line 154
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->dismiss()V

    .line 171
    :goto_0
    return-object v0

    .line 160
    :cond_0
    invoke-virtual {v0, v5}, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V

    .line 161
    invoke-virtual {p0, v5}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->setCancelable(Z)V

    .line 163
    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v2

    const/16 v3, 0x400

    invoke-virtual {v2, v3}, Landroid/view/Window;->clearFlags(I)V

    .line 164
    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2, v4, v4}, Landroid/view/Window;->setLayout(II)V

    .line 165
    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v2

    const/16 v3, 0x33

    invoke-virtual {v2, v3}, Landroid/view/Window;->setGravity(I)V

    .line 167
    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v1

    .line 168
    .local v1, "params":Landroid/view/WindowManager$LayoutParams;
    sget v2, Lcom/amazon/retailsearch/R$style;->PopupDialogFragmentAnimation:I

    iput v2, v1, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    .line 169
    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->setDialogBounds(Landroid/app/Dialog;)V

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 178
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 179
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 182
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    return-object v0
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    .line 187
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onDestroyView()V

    .line 189
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mCloseListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnCloseListener;

    if-eqz v0, :cond_0

    .line 190
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mCloseListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnCloseListener;

    invoke-interface {v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnCloseListener;->onClose()V

    .line 193
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 194
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 195
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 198
    :cond_1
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mAnchorId:I

    .line 199
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    .line 201
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
    .line 281
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    invoke-virtual {p1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    new-instance v1, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$3;-><init>(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;Landroid/view/View;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 292
    return-void
.end method

.method public setOnCloseListener(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnCloseListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnCloseListener;

    .prologue
    .line 65
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mCloseListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnCloseListener;

    .line 66
    return-void
.end method

.method public setOnSizeChangedListener(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;

    .prologue
    .line 69
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;

    .line 70
    return-void
.end method

.method public setPosition(Lcom/amazon/retailsearch/popup/Position;)V
    .locals 1
    .param p1, "position"    # Lcom/amazon/retailsearch/popup/Position;

    .prologue
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    const/4 v0, 0x0

    .line 208
    invoke-virtual {p0, p1, v0, v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->setPosition(Lcom/amazon/retailsearch/popup/Position;II)V

    .line 209
    return-void
.end method

.method public setPosition(Lcom/amazon/retailsearch/popup/Position;II)V
    .locals 1
    .param p1, "position"    # Lcom/amazon/retailsearch/popup/Position;
    .param p2, "xOffset"    # I
    .param p3, "yOffset"    # I

    .prologue
    .line 212
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 213
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mPosition:Lcom/amazon/retailsearch/popup/Position;

    .line 214
    iput p2, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mXOffset:I

    .line 215
    iput p3, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mYOffset:I

    .line 216
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->setDialogBounds(Landroid/app/Dialog;)V

    .line 218
    :cond_0
    return-void
.end method

.method public show(Landroid/support/v4/app/FragmentManager;ILandroid/view/View;Lcom/amazon/retailsearch/popup/Position;II)V
    .locals 9
    .param p1, "manager"    # Landroid/support/v4/app/FragmentManager;
    .param p2, "anchorId"    # I
    .param p3, "content"    # Landroid/view/View;
    .param p4, "position"    # Lcom/amazon/retailsearch/popup/Position;
    .param p5, "width"    # I
    .param p6, "height"    # I

    .prologue
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    const/4 v5, 0x0

    .line 82
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    move v6, v5

    move v7, p5

    move v8, p6

    invoke-virtual/range {v0 .. v8}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->show(Landroid/support/v4/app/FragmentManager;ILandroid/view/View;Lcom/amazon/retailsearch/popup/Position;IIII)V

    .line 83
    return-void
.end method

.method public show(Landroid/support/v4/app/FragmentManager;ILandroid/view/View;Lcom/amazon/retailsearch/popup/Position;IIII)V
    .locals 4
    .param p1, "manager"    # Landroid/support/v4/app/FragmentManager;
    .param p2, "anchorId"    # I
    .param p3, "content"    # Landroid/view/View;
    .param p4, "position"    # Lcom/amazon/retailsearch/popup/Position;
    .param p5, "xOffset"    # I
    .param p6, "yOffset"    # I
    .param p7, "width"    # I
    .param p8, "height"    # I

    .prologue
    .line 98
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>;"
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 121
    :goto_0
    return-void

    .line 102
    :cond_0
    iput p2, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mAnchorId:I

    .line 103
    iput-object p3, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mContent:Landroid/view/View;

    .line 104
    iput-object p4, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mPosition:Lcom/amazon/retailsearch/popup/Position;

    .line 105
    iput p5, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mXOffset:I

    .line 106
    iput p6, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mYOffset:I

    .line 107
    iput p7, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->width:I

    .line 108
    iput p8, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->height:I

    .line 111
    :try_start_0
    invoke-virtual {p1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 113
    .local v1, "transaction":Landroid/support/v4/app/FragmentTransaction;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->isAddToBackStackAllowed()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 114
    const-string/jumbo v2, "popup_dialog_fragment"

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 117
    :cond_1
    const-string/jumbo v2, "popup_dialog_fragment"

    invoke-virtual {p0, v1, v2}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->show(Landroid/support/v4/app/FragmentTransaction;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 118
    .end local v1    # "transaction":Landroid/support/v4/app/FragmentTransaction;
    :catch_0
    move-exception v0

    .line 119
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v3, "Error while displaying popup dialog fragment"

    invoke-interface {v2, v3, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
