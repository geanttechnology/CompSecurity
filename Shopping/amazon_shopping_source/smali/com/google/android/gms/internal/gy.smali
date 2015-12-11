.class public final Lcom/google/android/gms/internal/gy;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/gy$a;
    }
.end annotation


# instance fields
.field private final DJ:Landroid/view/View;

.field private final FU:Lcom/google/android/gms/internal/gy$a;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/Collection;ILandroid/view/View;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;I",
            "Landroid/view/View;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/gy$a;

    invoke-direct {v0, p1, p2, p3, p5}, Lcom/google/android/gms/internal/gy$a;-><init>(Ljava/lang/String;Ljava/util/Collection;ILjava/lang/String;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/gy;->FU:Lcom/google/android/gms/internal/gy$a;

    iput-object p4, p0, Lcom/google/android/gms/internal/gy;->DJ:Landroid/view/View;

    return-void
.end method


# virtual methods
.method public fl()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/gy;->FU:Lcom/google/android/gms/internal/gy$a;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gy$a;->fl()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
