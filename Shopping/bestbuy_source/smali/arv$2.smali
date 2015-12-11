.class Larv$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Larv;->a()V
.end annotation


# instance fields
.field final synthetic a:Larv;


# direct methods
.method constructor <init>(Larv;)V
    .locals 0

    iput-object p1, p0, Larv$2;->a:Larv;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    iget-object v0, p0, Larv$2;->a:Larv;

    invoke-static {v0}, Larv;->a(Larv;)Laqs;

    move-result-object v0

    invoke-interface {v0}, Laqs;->a()V

    return-void
.end method
