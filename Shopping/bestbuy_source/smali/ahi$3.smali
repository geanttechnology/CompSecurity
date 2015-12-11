.class Lahi$3;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


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

    iput-object p1, p0, Lahi$3;->b:Lahi;

    iput-object p2, p0, Lahi$3;->a:Lahl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    iget-object v0, p0, Lahi$3;->a:Lahl;

    invoke-virtual {v0}, Lahl;->a()V

    return-void
.end method
