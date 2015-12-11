.class public Lcom/amazon/retailsearch/android/ui/results/layout/Margins;
.super Ljava/lang/Object;
.source "Margins.java"


# instance fields
.field private final bottom:I

.field private final left:I

.field private final right:I

.field private final top:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;-><init>(I)V

    .line 17
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->bottom:I

    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->right:I

    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->top:I

    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->left:I

    .line 24
    return-void
.end method

.method public constructor <init>(IIII)V
    .locals 0
    .param p1, "left"    # I
    .param p2, "top"    # I
    .param p3, "right"    # I
    .param p4, "bottom"    # I

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->left:I

    .line 36
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->top:I

    .line 37
    iput p3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->right:I

    .line 38
    iput p4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->bottom:I

    .line 39
    return-void
.end method

.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/Margins;)V
    .locals 1
    .param p1, "margins"    # Lcom/amazon/retailsearch/android/ui/results/layout/Margins;

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iget v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->left:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->left:I

    .line 48
    iget v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->top:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->top:I

    .line 49
    iget v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->right:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->right:I

    .line 50
    iget v0, p1, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->bottom:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->bottom:I

    .line 51
    return-void
.end method


# virtual methods
.method public getBottom()I
    .locals 1

    .prologue
    .line 78
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->bottom:I

    return v0
.end method

.method public getLeft()I
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->left:I

    return v0
.end method

.method public getRight()I
    .locals 1

    .prologue
    .line 71
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->right:I

    return v0
.end method

.method public getTop()I
    .locals 1

    .prologue
    .line 64
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/Margins;->top:I

    return v0
.end method
