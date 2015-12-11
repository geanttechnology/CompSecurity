.class Lsu$3;
.super Ljava/lang/Object;

# interfaces
.implements Lacf;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsu;->a(Lss;)V
.end annotation


# instance fields
.field final synthetic a:Lss;

.field final synthetic b:Lsu;


# direct methods
.method constructor <init>(Lsu;Lss;)V
    .locals 0

    iput-object p1, p0, Lsu$3;->b:Lsu;

    iput-object p2, p0, Lsu$3;->a:Lss;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/google/android/gms/internal/gu;)V
    .locals 1

    iget-object v0, p0, Lsu$3;->a:Lss;

    invoke-interface {v0}, Lss;->a()V

    return-void
.end method
