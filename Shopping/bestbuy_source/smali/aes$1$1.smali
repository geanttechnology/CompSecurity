.class Laes$1$1;
.super Ljava/lang/Object;

# interfaces
.implements Laig;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laes$1;->a(Lafd;)V
.end annotation


# instance fields
.field final synthetic a:Laes$1;


# direct methods
.method constructor <init>(Laes$1;)V
    .locals 0

    iput-object p1, p0, Laes$1$1;->a:Laes$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(I[Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Laes$1$1;->a:Laes$1;

    invoke-static {p1}, Laia;->b(I)Lcom/google/android/gms/common/api/Status;

    move-result-object v1

    invoke-virtual {v0, v1}, Laes$1;->a(Lqt;)V

    return-void
.end method
