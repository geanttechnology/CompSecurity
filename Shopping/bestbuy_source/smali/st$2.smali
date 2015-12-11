.class Lst$2;
.super Ljava/lang/Object;

# interfaces
.implements Lss;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lst;->a(Landroid/content/Context;Lcom/google/android/gms/internal/gs;Labs;)Lsr;
.end annotation


# instance fields
.field final synthetic a:Labs;

.field final synthetic b:Lsr;

.field final synthetic c:Lst;


# direct methods
.method constructor <init>(Lst;Labs;Lsr;)V
    .locals 0

    iput-object p1, p0, Lst$2;->c:Lst;

    iput-object p2, p0, Lst$2;->a:Labs;

    iput-object p3, p0, Lst$2;->b:Lsr;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    iget-object v0, p0, Lst$2;->a:Labs;

    iget-object v1, p0, Lst$2;->b:Lsr;

    invoke-virtual {v0, v1}, Labs;->a(Ljava/lang/Object;)V

    return-void
.end method
