.class public Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;
.super Ltv/freewheel/renderers/html/MRAIDBackgroundView;
.source "MRAIDCustomViewBackgroundView.java"


# instance fields
.field private closeButton:Landroid/widget/ImageButton;

.field private logger:Ltv/freewheel/utils/Logger;

.field private webChromeClient:Landroid/webkit/WebChromeClient;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/webkit/WebChromeClient;)V
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "webChromeClient"    # Landroid/webkit/WebChromeClient;

    .prologue
    const/4 v1, 0x0

    const/16 v4, 0x32

    const/4 v3, 0x0

    .line 18
    invoke-direct {p0, p1}, Ltv/freewheel/renderers/html/MRAIDBackgroundView;-><init>(Landroid/app/Activity;)V

    .line 13
    iput-object v1, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->closeButton:Landroid/widget/ImageButton;

    .line 14
    iput-object v1, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->webChromeClient:Landroid/webkit/WebChromeClient;

    .line 19
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v1

    iput-object v1, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->logger:Ltv/freewheel/utils/Logger;

    .line 20
    iput-object p2, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->webChromeClient:Landroid/webkit/WebChromeClient;

    .line 21
    new-instance v1, Landroid/widget/ImageButton;

    invoke-direct {v1, p1}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->closeButton:Landroid/widget/ImageButton;

    .line 22
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->closeButton:Landroid/widget/ImageButton;

    const v2, 0x108005a

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 23
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v1, v3}, Landroid/widget/ImageButton;->setBackgroundColor(I)V

    .line 24
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v1, v3, v3, v3, v3}, Landroid/widget/ImageButton;->setPadding(IIII)V

    .line 25
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, v4, v4}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 26
    .local v0, "fl":Landroid/widget/FrameLayout$LayoutParams;
    const/16 v1, 0x35

    iput v1, v0, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 27
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {p0, v1, v0}, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 28
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->closeButton:Landroid/widget/ImageButton;

    new-instance v2, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView$1;

    invoke-direct {v2, p0}, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView$1;-><init>(Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 34
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;

    .prologue
    .line 12
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->logger:Ltv/freewheel/utils/Logger;

    return-object v0
.end method

.method static synthetic access$100(Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;)Landroid/webkit/WebChromeClient;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;

    .prologue
    .line 12
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->webChromeClient:Landroid/webkit/WebChromeClient;

    return-object v0
.end method


# virtual methods
.method public bridge synthetic onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "x0"    # Landroid/view/MotionEvent;

    .prologue
    .line 12
    invoke-super {p0, p1}, Ltv/freewheel/renderers/html/MRAIDBackgroundView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method
