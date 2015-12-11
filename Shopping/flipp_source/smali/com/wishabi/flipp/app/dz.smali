.class final Lcom/wishabi/flipp/app/dz;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/ec;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/SearchFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/SearchFragment;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/wishabi/flipp/app/dz;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(II)Z
    .locals 1

    .prologue
    .line 132
    if-ne p1, p2, :cond_0

    .line 133
    const/4 v0, 0x0

    .line 137
    :goto_0
    return v0

    .line 135
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/dz;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0, p2}, Lcom/wishabi/flipp/app/SearchFragment;->a(Lcom/wishabi/flipp/app/SearchFragment;I)I

    .line 136
    iget-object v0, p0, Lcom/wishabi/flipp/app/dz;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->a(Lcom/wishabi/flipp/app/SearchFragment;)V

    .line 137
    const/4 v0, 0x1

    goto :goto_0
.end method
