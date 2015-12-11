.class Lbn$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lbn;->getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lbn;


# direct methods
.method constructor <init>(Lbn;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lbn$4;->b:Lbn;

    iput-object p2, p0, Lbn$4;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 174
    iget-object v0, p0, Lbn$4;->b:Lbn;

    iget-object v1, p0, Lbn$4;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lbn;->b(Ljava/lang/String;)V

    .line 175
    return-void
.end method
