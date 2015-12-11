.class public Lcom/wishabi/flipp/util/o;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/util/m;",
            ">;"
        }
    .end annotation
.end field

.field public final b:I

.field public c:I

.field public d:I

.field public final e:Ljava/lang/String;

.field private final f:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/util/m;",
            ">;"
        }
    .end annotation
.end field

.field private final g:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/util/m;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(I)V
    .locals 1

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/util/o;->f:Ljava/util/ArrayList;

    .line 62
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/util/o;->g:Ljava/util/ArrayList;

    .line 64
    const/4 v0, -0x1

    iput v0, p0, Lcom/wishabi/flipp/util/o;->c:I

    .line 69
    iput p1, p0, Lcom/wishabi/flipp/util/o;->b:I

    .line 70
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/util/o;->e:Ljava/lang/String;

    .line 71
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/util/o;->f:Ljava/util/ArrayList;

    .line 62
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/util/o;->g:Ljava/util/ArrayList;

    .line 64
    const/4 v0, -0x1

    iput v0, p0, Lcom/wishabi/flipp/util/o;->c:I

    .line 74
    iput p1, p0, Lcom/wishabi/flipp/util/o;->b:I

    .line 75
    iput-object p2, p0, Lcom/wishabi/flipp/util/o;->e:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public static a(II)Lcom/wishabi/flipp/util/o;
    .locals 2

    .prologue
    .line 57
    new-instance v0, Lcom/wishabi/flipp/util/n;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/wishabi/flipp/util/n;-><init>(IIB)V

    return-object v0
.end method

.method public static a(IILjava/lang/String;)Lcom/wishabi/flipp/util/o;
    .locals 2

    .prologue
    .line 53
    new-instance v0, Lcom/wishabi/flipp/util/n;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/wishabi/flipp/util/n;-><init>(IILjava/lang/String;B)V

    return-object v0
.end method

.method private c()V
    .locals 2

    .prologue
    .line 161
    iget v0, p0, Lcom/wishabi/flipp/util/o;->c:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 162
    new-instance v0, Ljava/lang/IllegalAccessError;

    const-string v1, "Can\'t modify a section after it has already been added to a SectionedCollection"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v0

    .line 164
    :cond_0
    return-void
.end method


# virtual methods
.method public a()I
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget-object v1, p0, Lcom/wishabi/flipp/util/o;->f:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/wishabi/flipp/util/o;->g:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public a(I)Lcom/wishabi/flipp/util/m;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->f:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/m;

    return-object v0
.end method

.method public a(Lcom/wishabi/flipp/util/m;)V
    .locals 1

    .prologue
    .line 94
    invoke-direct {p0}, Lcom/wishabi/flipp/util/o;->c()V

    .line 95
    iget v0, p0, Lcom/wishabi/flipp/util/o;->b:I

    iput v0, p1, Lcom/wishabi/flipp/util/m;->b:I

    .line 96
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 97
    return-void
.end method

.method public b()I
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->f:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public b(I)Lcom/wishabi/flipp/util/m;
    .locals 3

    .prologue
    .line 146
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 147
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/m;

    .line 153
    :goto_0
    return-object v0

    .line 149
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->f:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget-object v1, p0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/2addr v0, v1

    if-ge p1, v0, :cond_1

    .line 150
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->f:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    sub-int v1, p1, v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/m;

    goto :goto_0

    .line 152
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget-object v1, p0, Lcom/wishabi/flipp/util/o;->f:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/2addr v0, v1

    if-ge p1, v0, :cond_2

    .line 153
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->g:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/wishabi/flipp/util/o;->f:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    sub-int v1, p1, v1

    iget-object v2, p0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/m;

    goto :goto_0

    .line 155
    :cond_2
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0
.end method

.method public b(Lcom/wishabi/flipp/util/m;)V
    .locals 1

    .prologue
    .line 100
    invoke-direct {p0}, Lcom/wishabi/flipp/util/o;->c()V

    .line 101
    iget v0, p0, Lcom/wishabi/flipp/util/o;->b:I

    iput v0, p1, Lcom/wishabi/flipp/util/m;->b:I

    .line 102
    iget-object v0, p0, Lcom/wishabi/flipp/util/o;->f:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 103
    return-void
.end method
