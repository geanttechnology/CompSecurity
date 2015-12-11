.class Lahi$2;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lahi;->a(Labe;)V
.end annotation


# instance fields
.field final synthetic a:Lahl;

.field final synthetic b:Lahi;


# direct methods
.method constructor <init>(Lahi;Lahl;)V
    .locals 0

    iput-object p1, p0, Lahi$2;->b:Lahi;

    iput-object p2, p0, Lahi$2;->a:Lahl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1

    iget-object v0, p0, Lahi$2;->a:Lahl;

    invoke-virtual {v0}, Lahl;->a()V

    const/4 v0, 0x0

    return v0
.end method
