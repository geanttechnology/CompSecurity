.class final Lavy;
.super Lavx;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lavx",
        "<",
        "Laug;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lqk;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqk",
            "<",
            "Laug;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lavx;-><init>(Lqk;)V

    return-void
.end method


# virtual methods
.method public a(Lcom/google/android/gms/wearable/internal/v;)V
    .locals 3

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iget-object v1, p1, Lcom/google/android/gms/wearable/internal/v;->c:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    new-instance v1, Lavn;

    iget v2, p1, Lcom/google/android/gms/wearable/internal/v;->b:I

    invoke-static {v2}, Lavt;->a(I)Lcom/google/android/gms/common/api/Status;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lavn;-><init>(Lcom/google/android/gms/common/api/Status;Ljava/util/List;)V

    invoke-virtual {p0, v1}, Lavy;->a(Ljava/lang/Object;)V

    return-void
.end method
