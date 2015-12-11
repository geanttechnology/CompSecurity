.class public Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;
.super Landroid/widget/ImageView;
.source "ImageStaticLayoutView.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private makeRequest:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 19
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;->makeRequest:Z

    .line 23
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 26
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 27
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 30
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 19
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;->makeRequest:Z

    .line 31
    return-void
.end method


# virtual methods
.method public requestLayout()V
    .locals 1

    .prologue
    .line 49
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;->makeRequest:Z

    if-eqz v0, :cond_0

    .line 50
    invoke-super {p0}, Landroid/widget/ImageView;->requestLayout()V

    .line 52
    :cond_0
    return-void
.end method

.method public setImageBitmap(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 35
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;->makeRequest:Z

    .line 36
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 37
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;->makeRequest:Z

    .line 38
    return-void
.end method

.method public setImageDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 42
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;->makeRequest:Z

    .line 43
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 44
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView;->makeRequest:Z

    .line 45
    return-void
.end method
