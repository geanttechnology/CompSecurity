.class final Lcom/wishabi/flipp/app/ep;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/eb;


# instance fields
.field final synthetic a:Landroid/content/Context;

.field final synthetic b:I

.field final synthetic c:I

.field final synthetic d:I


# direct methods
.method constructor <init>(Landroid/content/Context;III)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/wishabi/flipp/app/ep;->a:Landroid/content/Context;

    iput p2, p0, Lcom/wishabi/flipp/app/ep;->b:I

    iput p3, p0, Lcom/wishabi/flipp/app/ep;->c:I

    iput p4, p0, Lcom/wishabi/flipp/app/ep;->d:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 57
    const/4 v0, 0x2

    return v0
.end method

.method public final a(Landroid/view/ViewGroup;I)Landroid/view/View;
    .locals 4

    .prologue
    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/app/ep;->a:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 34
    const v1, 0x7f03004b

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 35
    const v0, 0x7f0b0119

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 36
    const v1, 0x7f0b011a

    invoke-virtual {v2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 38
    packed-switch p2, :pswitch_data_0

    .line 49
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid tab index"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 40
    :pswitch_0
    invoke-static {}, Lcom/wishabi/flipp/util/q;->b()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 42
    iget v0, p0, Lcom/wishabi/flipp/app/ep;->b:I

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 52
    :goto_0
    return-object v2

    .line 45
    :pswitch_1
    const v3, 0x7f0e0086

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(I)V

    .line 46
    iget v0, p0, Lcom/wishabi/flipp/app/ep;->c:I

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 38
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final a(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    const/4 v0, 0x0

    return-object v0
.end method

.method public final b()Z
    .locals 1

    .prologue
    .line 62
    const/4 v0, 0x0

    return v0
.end method

.method public final c()I
    .locals 1

    .prologue
    .line 72
    iget v0, p0, Lcom/wishabi/flipp/app/ep;->d:I

    return v0
.end method
