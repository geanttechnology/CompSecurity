.class public Lco/vine/android/views/FlowLayout$LayoutParams;
.super Landroid/view/ViewGroup$LayoutParams;
.source "FlowLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/views/FlowLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LayoutParams"
.end annotation


# static fields
.field private static NO_SPACING:I


# instance fields
.field private horizontalSpacing:I

.field private newLine:Z

.field private verticalSpacing:I

.field private x:I

.field private y:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 273
    const/4 v0, -0x1

    sput v0, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    return-void
.end method

.method public constructor <init>(II)V
    .locals 1
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 286
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 276
    sget v0, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    iput v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I

    .line 277
    sget v0, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    iput v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I

    .line 278
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->newLine:Z

    .line 287
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attributeSet"    # Landroid/util/AttributeSet;

    .prologue
    .line 281
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 276
    sget v0, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    iput v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I

    .line 277
    sget v0, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    iput v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I

    .line 278
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->newLine:Z

    .line 282
    invoke-direct {p0, p1, p2}, Lco/vine/android/views/FlowLayout$LayoutParams;->readStyleParameters(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 283
    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1
    .param p1, "layoutParams"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 290
    invoke-direct {p0, p1}, Landroid/view/ViewGroup$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    .line 276
    sget v0, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    iput v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I

    .line 277
    sget v0, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    iput v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I

    .line 278
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->newLine:Z

    .line 291
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/views/FlowLayout$LayoutParams;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/FlowLayout$LayoutParams;

    .prologue
    .line 272
    iget-boolean v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->newLine:Z

    return v0
.end method

.method static synthetic access$100(Lco/vine/android/views/FlowLayout$LayoutParams;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/FlowLayout$LayoutParams;

    .prologue
    .line 272
    iget v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I

    return v0
.end method

.method static synthetic access$200(Lco/vine/android/views/FlowLayout$LayoutParams;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/FlowLayout$LayoutParams;

    .prologue
    .line 272
    iget v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I

    return v0
.end method

.method static synthetic access$300(Lco/vine/android/views/FlowLayout$LayoutParams;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/FlowLayout$LayoutParams;

    .prologue
    .line 272
    iget v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->x:I

    return v0
.end method

.method static synthetic access$400(Lco/vine/android/views/FlowLayout$LayoutParams;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/views/FlowLayout$LayoutParams;

    .prologue
    .line 272
    iget v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->y:I

    return v0
.end method

.method private readStyleParameters(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attributeSet"    # Landroid/util/AttributeSet;

    .prologue
    .line 307
    sget v0, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    iput v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I

    .line 308
    sget v0, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    iput v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I

    .line 309
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->newLine:Z

    .line 310
    return-void
.end method


# virtual methods
.method public horizontalSpacingSpecified()Z
    .locals 2

    .prologue
    .line 294
    iget v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I

    sget v1, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setPosition(II)V
    .locals 0
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 302
    iput p1, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->x:I

    .line 303
    iput p2, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->y:I

    .line 304
    return-void
.end method

.method public verticalSpacingSpecified()Z
    .locals 2

    .prologue
    .line 298
    iget v0, p0, Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I

    sget v1, Lco/vine/android/views/FlowLayout$LayoutParams;->NO_SPACING:I

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
