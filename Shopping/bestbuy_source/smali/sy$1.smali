.class Lsy$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsy;->a(Landroid/view/View;)Z
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lsy;


# direct methods
.method constructor <init>(Lsy;Landroid/view/View;)V
    .locals 0

    iput-object p1, p0, Lsy$1;->b:Lsy;

    iput-object p2, p0, Lsy$1;->a:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lsy$1;->b:Lsy;

    iget-object v1, p0, Lsy$1;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Lsy;->b(Landroid/view/View;)V

    return-void
.end method
