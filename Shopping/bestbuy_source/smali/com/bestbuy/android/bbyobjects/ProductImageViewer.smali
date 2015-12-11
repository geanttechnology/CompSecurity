.class public Lcom/bestbuy/android/bbyobjects/ProductImageViewer;
.super Landroid/widget/LinearLayout;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# instance fields
.field private a:Lko;

.field private b:Lkp;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 28
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 32
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 36
    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 0

    .prologue
    .line 117
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0

    .prologue
    .line 122
    return-void
.end method

.method public onPageSelected(I)V
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/ProductImageViewer;->a:Lko;

    invoke-virtual {v0, p1}, Lko;->a(I)V

    .line 127
    return-void
.end method

.method public setPromoPagerListener(Lkp;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/ProductImageViewer;->b:Lkp;

    .line 135
    return-void
.end method
