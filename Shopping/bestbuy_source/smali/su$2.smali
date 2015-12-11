.class Lsu$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsu;->a(Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lsu;


# direct methods
.method constructor <init>(Lsu;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lsu$2;->b:Lsu;

    iput-object p2, p0, Lsu$2;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lsu$2;->b:Lsu;

    invoke-static {v0}, Lsu;->a(Lsu;)Lcom/google/android/gms/internal/gu;

    move-result-object v0

    iget-object v1, p0, Lsu$2;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/gu;->loadUrl(Ljava/lang/String;)V

    return-void
.end method
