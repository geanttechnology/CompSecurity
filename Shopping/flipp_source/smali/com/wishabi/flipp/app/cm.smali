.class public final Lcom/wishabi/flipp/app/cm;
.super Landroid/app/Fragment;
.source "SourceFile"


# instance fields
.field private a:I

.field private b:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 110
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method

.method public static a(ILandroid/view/View;)Lcom/wishabi/flipp/app/cm;
    .locals 2

    .prologue
    .line 115
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 116
    const-string v1, "resource_id"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 117
    new-instance v1, Lcom/wishabi/flipp/app/cm;

    invoke-direct {v1}, Lcom/wishabi/flipp/app/cm;-><init>()V

    .line 118
    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/app/cm;->setArguments(Landroid/os/Bundle;)V

    .line 119
    iput-object p1, v1, Lcom/wishabi/flipp/app/cm;->b:Landroid/view/View;

    .line 120
    return-object v1
.end method


# virtual methods
.method public final onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 125
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 127
    if-eqz p1, :cond_0

    .line 129
    :goto_0
    if-nez p1, :cond_1

    .line 130
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Fragment arguments not provided."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 127
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cm;->getArguments()Landroid/os/Bundle;

    move-result-object p1

    goto :goto_0

    .line 132
    :cond_1
    const-string v0, "resource_id"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/cm;->a:I

    .line 133
    return-void
.end method

.method public final onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 138
    iget v0, p0, Lcom/wishabi/flipp/app/cm;->a:I

    if-nez v0, :cond_0

    .line 139
    const/4 v0, 0x0

    .line 145
    :goto_0
    return-object v0

    .line 141
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/cm;->b:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 142
    iget-object v0, p0, Lcom/wishabi/flipp/app/cm;->b:Landroid/view/View;

    goto :goto_0

    .line 144
    :cond_1
    iget v0, p0, Lcom/wishabi/flipp/app/cm;->a:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/cm;->b:Landroid/view/View;

    .line 145
    iget-object v0, p0, Lcom/wishabi/flipp/app/cm;->b:Landroid/view/View;

    goto :goto_0
.end method

.method public final onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 150
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 151
    const-string v0, "resource_id"

    iget v1, p0, Lcom/wishabi/flipp/app/cm;->a:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 152
    return-void
.end method
