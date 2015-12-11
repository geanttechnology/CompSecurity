.class final Lmg;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/zxing/ResultPointCallback;


# instance fields
.field private final a:Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;)V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lmg;->a:Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;

    .line 12
    return-void
.end method


# virtual methods
.method public foundPossibleResultPoint(Lcom/google/zxing/ResultPoint;)V
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lmg;->a:Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;->a(Lcom/google/zxing/ResultPoint;)V

    .line 16
    return-void
.end method
