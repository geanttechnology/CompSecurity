.class Larq;
.super Ljava/lang/Object;


# static fields
.field private static final a:Larf;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Larf",
            "<",
            "Lwk;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final b:Laqo;

.field private final c:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Laqp;",
            ">;"
        }
    .end annotation
.end field

.field private final d:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Laqp;",
            ">;"
        }
    .end annotation
.end field

.field private final e:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Laqp;",
            ">;"
        }
    .end annotation
.end field

.field private final f:Lasc;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lasc",
            "<",
            "Larn;",
            "Larf",
            "<",
            "Lwk;",
            ">;>;"
        }
    .end annotation
.end field

.field private final g:Lasc;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lasc",
            "<",
            "Ljava/lang/String;",
            "Lars;",
            ">;"
        }
    .end annotation
.end field

.field private final h:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Laro;",
            ">;"
        }
    .end annotation
.end field

.field private final i:Laqg;

.field private final j:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lart;",
            ">;"
        }
    .end annotation
.end field

.field private volatile k:Ljava/lang/String;

.field private l:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    new-instance v0, Larf;

    invoke-static {}, Larz;->a()Lwk;

    move-result-object v1

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Larf;-><init>(Ljava/lang/Object;Z)V

    sput-object v0, Larq;->a:Larf;

    return-void
.end method

.method private a(Ljava/lang/String;Ljava/util/Set;Laqx;)Larf;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Laqx;",
            ")",
            "Larf",
            "<",
            "Lwk;",
            ">;"
        }
    .end annotation

    const/4 v10, 0x1

    iget v0, p0, Larq;->l:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Larq;->l:I

    iget-object v0, p0, Larq;->g:Lasc;

    invoke-interface {v0, p1}, Lasc;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lars;

    if-eqz v0, :cond_0

    iget-object v1, p0, Larq;->b:Laqo;

    invoke-interface {v1}, Laqo;->a()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lars;->b()Lwk;

    move-result-object v1

    invoke-direct {p0, v1, p2}, Larq;->a(Lwk;Ljava/util/Set;)V

    iget v1, p0, Larq;->l:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Larq;->l:I

    invoke-virtual {v0}, Lars;->a()Larf;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Larq;->j:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    move-object v9, v0

    check-cast v9, Lart;

    if-nez v9, :cond_1

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Larq;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "Invalid macro: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    iget v0, p0, Larq;->l:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Larq;->l:I

    sget-object v0, Larq;->a:Larf;

    goto :goto_0

    :cond_1
    invoke-virtual {v9}, Lart;->a()Ljava/util/Set;

    move-result-object v2

    invoke-virtual {v9}, Lart;->b()Ljava/util/Map;

    move-result-object v3

    invoke-virtual {v9}, Lart;->c()Ljava/util/Map;

    move-result-object v4

    invoke-virtual {v9}, Lart;->e()Ljava/util/Map;

    move-result-object v5

    invoke-virtual {v9}, Lart;->d()Ljava/util/Map;

    move-result-object v6

    invoke-interface {p3}, Laqx;->b()Larp;

    move-result-object v8

    move-object v0, p0

    move-object v1, p1

    move-object v7, p2

    invoke-virtual/range {v0 .. v8}, Larq;->a(Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Larp;)Larf;

    move-result-object v1

    invoke-virtual {v1}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {v9}, Lart;->f()Larn;

    move-result-object v0

    move-object v2, v0

    :goto_1
    if-nez v2, :cond_4

    iget v0, p0, Larq;->l:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Larq;->l:I

    sget-object v0, Larq;->a:Larf;

    goto :goto_0

    :cond_2
    invoke-virtual {v1}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    if-le v0, v10, :cond_3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Larq;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "Multiple macros active for macroName "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Laqv;->b(Ljava/lang/String;)V

    :cond_3
    invoke-virtual {v1}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Larn;

    move-object v2, v0

    goto :goto_1

    :cond_4
    iget-object v0, p0, Larq;->e:Ljava/util/Map;

    invoke-interface {p3}, Laqx;->a()Lari;

    move-result-object v3

    invoke-direct {p0, v0, v2, p2, v3}, Larq;->a(Ljava/util/Map;Larn;Ljava/util/Set;Lari;)Larf;

    move-result-object v3

    invoke-virtual {v1}, Larf;->b()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-virtual {v3}, Larf;->b()Z

    move-result v0

    if-eqz v0, :cond_6

    move v0, v10

    :goto_2
    sget-object v1, Larq;->a:Larf;

    if-ne v3, v1, :cond_7

    sget-object v0, Larq;->a:Larf;

    :goto_3
    invoke-virtual {v2}, Larn;->b()Lwk;

    move-result-object v1

    invoke-virtual {v0}, Larf;->b()Z

    move-result v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Larq;->g:Lasc;

    new-instance v3, Lars;

    invoke-direct {v3, v0, v1}, Lars;-><init>(Larf;Lwk;)V

    invoke-interface {v2, p1, v3}, Lasc;->a(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_5
    invoke-direct {p0, v1, p2}, Larq;->a(Lwk;Ljava/util/Set;)V

    iget v1, p0, Larq;->l:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Larq;->l:I

    goto/16 :goto_0

    :cond_6
    const/4 v0, 0x0

    goto :goto_2

    :cond_7
    new-instance v1, Larf;

    invoke-virtual {v3}, Larf;->a()Ljava/lang/Object;

    move-result-object v3

    invoke-direct {v1, v3, v0}, Larf;-><init>(Ljava/lang/Object;Z)V

    move-object v0, v1

    goto :goto_3
.end method

.method private a(Ljava/util/Map;Larn;Ljava/util/Set;Lari;)Larf;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Laqp;",
            ">;",
            "Larn;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lari;",
            ")",
            "Larf",
            "<",
            "Lwk;",
            ">;"
        }
    .end annotation

    const/4 v5, 0x1

    const/4 v6, 0x0

    invoke-virtual {p2}, Larn;->a()Ljava/util/Map;

    move-result-object v0

    sget-object v1, Ltl;->aL:Ltl;

    invoke-virtual {v1}, Ltl;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lwk;

    if-nez v0, :cond_1

    const-string v0, "No function id in properties"

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    sget-object v1, Larq;->a:Larf;

    :cond_0
    :goto_0
    return-object v1

    :cond_1
    iget-object v7, v0, Lwk;->g:Ljava/lang/String;

    invoke-interface {p1, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laqp;

    if-nez v0, :cond_2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " has no backing implementation."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    sget-object v1, Larq;->a:Larf;

    goto :goto_0

    :cond_2
    iget-object v1, p0, Larq;->f:Lasc;

    invoke-interface {v1, p2}, Lasc;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Larf;

    if-eqz v1, :cond_3

    iget-object v2, p0, Larq;->b:Laqo;

    invoke-interface {v2}, Laqo;->a()Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_3
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {p2}, Larn;->a()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    move v4, v5

    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {p4, v2}, Lari;->a(Ljava/lang/String;)Lark;

    move-result-object v10

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lwk;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lwk;

    invoke-interface {v10, v3}, Lark;->a(Lwk;)Lasa;

    move-result-object v3

    invoke-direct {p0, v2, p3, v3}, Larq;->a(Lwk;Ljava/util/Set;Lasa;)Larf;

    move-result-object v10

    sget-object v2, Larq;->a:Larf;

    if-ne v10, v2, :cond_4

    sget-object v1, Larq;->a:Larf;

    goto :goto_0

    :cond_4
    invoke-virtual {v10}, Larf;->b()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v10}, Larf;->a()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lwk;

    invoke-virtual {p2, v2, v3}, Larn;->a(Ljava/lang/String;Lwk;)V

    move v2, v4

    :goto_2
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v10}, Larf;->a()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v8, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move v4, v2

    goto :goto_1

    :cond_5
    move v2, v6

    goto :goto_2

    :cond_6
    invoke-interface {v8}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-virtual {v0, v1}, Laqp;->a(Ljava/util/Set;)Z

    move-result v1

    if-nez v1, :cond_7

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Incorrect keys for function "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " required "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Laqp;->b()Ljava/util/Set;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " had "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-interface {v8}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    sget-object v1, Larq;->a:Larf;

    goto/16 :goto_0

    :cond_7
    if-eqz v4, :cond_9

    invoke-virtual {v0}, Laqp;->a()Z

    move-result v1

    if-eqz v1, :cond_9

    :goto_3
    new-instance v1, Larf;

    invoke-virtual {v0, v8}, Laqp;->a(Ljava/util/Map;)Lwk;

    move-result-object v0

    invoke-direct {v1, v0, v5}, Larf;-><init>(Ljava/lang/Object;Z)V

    if-eqz v5, :cond_8

    iget-object v0, p0, Larq;->f:Lasc;

    invoke-interface {v0, p2, v1}, Lasc;->a(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_8
    invoke-virtual {v1}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lwk;

    invoke-interface {p4, v0}, Lari;->a(Lwk;)V

    goto/16 :goto_0

    :cond_9
    move v5, v6

    goto :goto_3
.end method

.method private a(Ljava/util/Set;Ljava/util/Set;Larr;Larp;)Larf;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Laro;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Larr;",
            "Larp;",
            ")",
            "Larf",
            "<",
            "Ljava/util/Set",
            "<",
            "Larn;",
            ">;>;"
        }
    .end annotation

    const/4 v3, 0x1

    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    new-instance v5, Ljava/util/HashSet;

    invoke-direct {v5}, Ljava/util/HashSet;-><init>()V

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move v2, v3

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laro;

    invoke-interface {p4}, Larp;->a()Larl;

    move-result-object v7

    invoke-virtual {p0, v0, p2, v7}, Larq;->a(Laro;Ljava/util/Set;Larl;)Larf;

    move-result-object v8

    invoke-virtual {v8}, Larf;->a()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {p3, v0, v4, v5, v7}, Larr;->a(Laro;Ljava/util/Set;Ljava/util/Set;Larl;)V

    :cond_0
    if-eqz v2, :cond_1

    invoke-virtual {v8}, Larf;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v3

    :goto_1
    move v2, v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1

    :cond_2
    invoke-interface {v4, v5}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    invoke-interface {p4, v4}, Larp;->a(Ljava/util/Set;)V

    new-instance v0, Larf;

    invoke-direct {v0, v4, v2}, Larf;-><init>(Ljava/lang/Object;Z)V

    return-object v0
.end method

.method private a(Lwk;Ljava/util/Set;Lasa;)Larf;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lwk;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lasa;",
            ")",
            "Larf",
            "<",
            "Lwk;",
            ">;"
        }
    .end annotation

    const/4 v2, 0x0

    iget-boolean v0, p1, Lwk;->l:Z

    if-nez v0, :cond_0

    new-instance v0, Larf;

    const/4 v1, 0x1

    invoke-direct {v0, p1, v1}, Larf;-><init>(Ljava/lang/Object;Z)V

    :goto_0
    return-object v0

    :cond_0
    iget v0, p1, Lwk;->a:I

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unknown type: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p1, Lwk;->a:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    sget-object v0, Larq;->a:Larf;

    goto :goto_0

    :pswitch_1
    invoke-static {p1}, Larm;->a(Lwk;)Lwk;

    move-result-object v3

    iget-object v0, p1, Lwk;->c:[Lwk;

    array-length v0, v0

    new-array v0, v0, [Lwk;

    iput-object v0, v3, Lwk;->c:[Lwk;

    move v1, v2

    :goto_1
    iget-object v0, p1, Lwk;->c:[Lwk;

    array-length v0, v0

    if-ge v1, v0, :cond_2

    iget-object v0, p1, Lwk;->c:[Lwk;

    aget-object v0, v0, v1

    invoke-interface {p3, v1}, Lasa;->a(I)Lasa;

    move-result-object v4

    invoke-direct {p0, v0, p2, v4}, Larq;->a(Lwk;Ljava/util/Set;Lasa;)Larf;

    move-result-object v0

    sget-object v4, Larq;->a:Larf;

    if-ne v0, v4, :cond_1

    sget-object v0, Larq;->a:Larf;

    goto :goto_0

    :cond_1
    iget-object v4, v3, Lwk;->c:[Lwk;

    invoke-virtual {v0}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lwk;

    aput-object v0, v4, v1

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    :cond_2
    new-instance v0, Larf;

    invoke-direct {v0, v3, v2}, Larf;-><init>(Ljava/lang/Object;Z)V

    goto :goto_0

    :pswitch_2
    invoke-static {p1}, Larm;->a(Lwk;)Lwk;

    move-result-object v3

    iget-object v0, p1, Lwk;->d:[Lwk;

    array-length v0, v0

    iget-object v1, p1, Lwk;->e:[Lwk;

    array-length v1, v1

    if-eq v0, v1, :cond_3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Invalid serving value: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lwk;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    sget-object v0, Larq;->a:Larf;

    goto/16 :goto_0

    :cond_3
    iget-object v0, p1, Lwk;->d:[Lwk;

    array-length v0, v0

    new-array v0, v0, [Lwk;

    iput-object v0, v3, Lwk;->d:[Lwk;

    iget-object v0, p1, Lwk;->d:[Lwk;

    array-length v0, v0

    new-array v0, v0, [Lwk;

    iput-object v0, v3, Lwk;->e:[Lwk;

    move v1, v2

    :goto_2
    iget-object v0, p1, Lwk;->d:[Lwk;

    array-length v0, v0

    if-ge v1, v0, :cond_6

    iget-object v0, p1, Lwk;->d:[Lwk;

    aget-object v0, v0, v1

    invoke-interface {p3, v1}, Lasa;->b(I)Lasa;

    move-result-object v4

    invoke-direct {p0, v0, p2, v4}, Larq;->a(Lwk;Ljava/util/Set;Lasa;)Larf;

    move-result-object v0

    iget-object v4, p1, Lwk;->e:[Lwk;

    aget-object v4, v4, v1

    invoke-interface {p3, v1}, Lasa;->c(I)Lasa;

    move-result-object v5

    invoke-direct {p0, v4, p2, v5}, Larq;->a(Lwk;Ljava/util/Set;Lasa;)Larf;

    move-result-object v4

    sget-object v5, Larq;->a:Larf;

    if-eq v0, v5, :cond_4

    sget-object v5, Larq;->a:Larf;

    if-ne v4, v5, :cond_5

    :cond_4
    sget-object v0, Larq;->a:Larf;

    goto/16 :goto_0

    :cond_5
    iget-object v5, v3, Lwk;->d:[Lwk;

    invoke-virtual {v0}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lwk;

    aput-object v0, v5, v1

    iget-object v5, v3, Lwk;->e:[Lwk;

    invoke-virtual {v4}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lwk;

    aput-object v0, v5, v1

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    :cond_6
    new-instance v0, Larf;

    invoke-direct {v0, v3, v2}, Larf;-><init>(Ljava/lang/Object;Z)V

    goto/16 :goto_0

    :pswitch_3
    iget-object v0, p1, Lwk;->f:Ljava/lang/String;

    invoke-interface {p2, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Macro cycle detected.  Current macro reference: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p1, Lwk;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "  Previous macro references: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    sget-object v0, Larq;->a:Larf;

    goto/16 :goto_0

    :cond_7
    iget-object v0, p1, Lwk;->f:Ljava/lang/String;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    iget-object v0, p1, Lwk;->f:Ljava/lang/String;

    invoke-interface {p3}, Lasa;->a()Laqx;

    move-result-object v1

    invoke-direct {p0, v0, p2, v1}, Larq;->a(Ljava/lang/String;Ljava/util/Set;Laqx;)Larf;

    move-result-object v0

    iget-object v1, p1, Lwk;->k:[I

    invoke-static {v0, v1}, Lasb;->a(Larf;[I)Larf;

    move-result-object v0

    iget-object v1, p1, Lwk;->f:Ljava/lang/String;

    invoke-interface {p2, v1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_4
    invoke-static {p1}, Larm;->a(Lwk;)Lwk;

    move-result-object v3

    iget-object v0, p1, Lwk;->j:[Lwk;

    array-length v0, v0

    new-array v0, v0, [Lwk;

    iput-object v0, v3, Lwk;->j:[Lwk;

    move v1, v2

    :goto_3
    iget-object v0, p1, Lwk;->j:[Lwk;

    array-length v0, v0

    if-ge v1, v0, :cond_9

    iget-object v0, p1, Lwk;->j:[Lwk;

    aget-object v0, v0, v1

    invoke-interface {p3, v1}, Lasa;->d(I)Lasa;

    move-result-object v4

    invoke-direct {p0, v0, p2, v4}, Larq;->a(Lwk;Ljava/util/Set;Lasa;)Larf;

    move-result-object v0

    sget-object v4, Larq;->a:Larf;

    if-ne v0, v4, :cond_8

    sget-object v0, Larq;->a:Larf;

    goto/16 :goto_0

    :cond_8
    iget-object v4, v3, Lwk;->j:[Lwk;

    invoke-virtual {v0}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lwk;

    aput-object v0, v4, v1

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    :cond_9
    new-instance v0, Larf;

    invoke-direct {v0, v3, v2}, Larf;-><init>(Ljava/lang/Object;Z)V

    goto/16 :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_4
    .end packed-switch
.end method

.method private a()Ljava/lang/String;
    .locals 3

    iget v0, p0, Larq;->l:I

    const/4 v1, 0x1

    if-gt v0, v1, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v0, p0, Larq;->l:I

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v0, 0x2

    :goto_1
    iget v2, p0, Larq;->l:I

    if-ge v0, v2, :cond_1

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_1
    const-string v0, ": "

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private a(Lwk;Ljava/util/Set;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lwk;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    new-instance v0, Lare;

    invoke-direct {v0}, Lare;-><init>()V

    invoke-direct {p0, p1, p2, v0}, Larq;->a(Lwk;Ljava/util/Set;Lasa;)Larf;

    move-result-object v0

    sget-object v1, Larq;->a:Larf;

    if-eq v0, v1, :cond_0

    invoke-virtual {v0}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lwk;

    invoke-static {v0}, Larz;->c(Lwk;)Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Ljava/util/Map;

    if-eqz v1, :cond_2

    check-cast v0, Ljava/util/Map;

    iget-object v1, p0, Larq;->i:Laqg;

    invoke-virtual {v1, v0}, Laqg;->a(Ljava/util/Map;)V

    goto :goto_0

    :cond_2
    instance-of v1, v0, Ljava/util/List;

    if-eqz v1, :cond_4

    check-cast v0, Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    instance-of v2, v0, Ljava/util/Map;

    if-eqz v2, :cond_3

    check-cast v0, Ljava/util/Map;

    iget-object v2, p0, Larq;->i:Laqg;

    invoke-virtual {v2, v0}, Laqg;->a(Ljava/util/Map;)V

    goto :goto_1

    :cond_3
    const-string v0, "pushAfterEvaluate: value not a Map"

    invoke-static {v0}, Laqv;->b(Ljava/lang/String;)V

    goto :goto_1

    :cond_4
    const-string v0, "pushAfterEvaluate: value not a Map or List"

    invoke-static {v0}, Laqv;->b(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method a(Larn;Ljava/util/Set;Lari;)Larf;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Larn;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lari;",
            ")",
            "Larf",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Larq;->d:Ljava/util/Map;

    invoke-direct {p0, v0, p1, p2, p3}, Larq;->a(Ljava/util/Map;Larn;Ljava/util/Set;Lari;)Larf;

    move-result-object v1

    invoke-virtual {v1}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lwk;

    invoke-static {v0}, Larz;->b(Lwk;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Larz;->c(Ljava/lang/Object;)Lwk;

    move-result-object v2

    invoke-interface {p3, v2}, Lari;->a(Lwk;)V

    new-instance v2, Larf;

    invoke-virtual {v1}, Larf;->b()Z

    move-result v1

    invoke-direct {v2, v0, v1}, Larf;-><init>(Ljava/lang/Object;Z)V

    return-object v2
.end method

.method a(Laro;Ljava/util/Set;Larl;)Larf;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Laro;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Larl;",
            ")",
            "Larf",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-virtual {p1}, Laro;->b()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move v1, v2

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Larn;

    invoke-interface {p3}, Larl;->a()Lari;

    move-result-object v5

    invoke-virtual {p0, v0, p2, v5}, Larq;->a(Larn;Ljava/util/Set;Lari;)Larf;

    move-result-object v5

    invoke-virtual {v5}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Larz;->c(Ljava/lang/Object;)Lwk;

    move-result-object v0

    invoke-interface {p3, v0}, Larl;->a(Lwk;)V

    new-instance v0, Larf;

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v5}, Larf;->b()Z

    move-result v2

    invoke-direct {v0, v1, v2}, Larf;-><init>(Ljava/lang/Object;Z)V

    :goto_1
    return-object v0

    :cond_0
    if-eqz v1, :cond_1

    invoke-virtual {v5}, Larf;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v2

    :goto_2
    move v1, v0

    goto :goto_0

    :cond_1
    move v0, v3

    goto :goto_2

    :cond_2
    invoke-virtual {p1}, Laro;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Larn;

    invoke-interface {p3}, Larl;->b()Lari;

    move-result-object v5

    invoke-virtual {p0, v0, p2, v5}, Larq;->a(Larn;Ljava/util/Set;Lari;)Larf;

    move-result-object v5

    invoke-virtual {v5}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Larz;->c(Ljava/lang/Object;)Lwk;

    move-result-object v0

    invoke-interface {p3, v0}, Larl;->a(Lwk;)V

    new-instance v0, Larf;

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v5}, Larf;->b()Z

    move-result v2

    invoke-direct {v0, v1, v2}, Larf;-><init>(Ljava/lang/Object;Z)V

    goto :goto_1

    :cond_3
    if-eqz v1, :cond_4

    invoke-virtual {v5}, Larf;->b()Z

    move-result v0

    if-eqz v0, :cond_4

    move v1, v2

    goto :goto_3

    :cond_4
    move v1, v3

    goto :goto_3

    :cond_5
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Larz;->c(Ljava/lang/Object;)Lwk;

    move-result-object v0

    invoke-interface {p3, v0}, Larl;->a(Lwk;)V

    new-instance v0, Larf;

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-direct {v0, v2, v1}, Larf;-><init>(Ljava/lang/Object;Z)V

    goto :goto_1
.end method

.method a(Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Larp;)Larf;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Laro;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Laro;",
            "Ljava/util/List",
            "<",
            "Larn;",
            ">;>;",
            "Ljava/util/Map",
            "<",
            "Laro;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/util/Map",
            "<",
            "Laro;",
            "Ljava/util/List",
            "<",
            "Larn;",
            ">;>;",
            "Ljava/util/Map",
            "<",
            "Laro;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Larp;",
            ")",
            "Larf",
            "<",
            "Ljava/util/Set",
            "<",
            "Larn;",
            ">;>;"
        }
    .end annotation

    new-instance v0, Larq$1;

    move-object v1, p0

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-direct/range {v0 .. v5}, Larq$1;-><init>(Larq;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V

    invoke-direct {p0, p2, p7, v0, p8}, Larq;->a(Ljava/util/Set;Ljava/util/Set;Larr;Larp;)Larf;

    move-result-object v0

    return-object v0
.end method

.method a(Ljava/util/Set;Larp;)Larf;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Laro;",
            ">;",
            "Larp;",
            ")",
            "Larf",
            "<",
            "Ljava/util/Set",
            "<",
            "Larn;",
            ">;>;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    new-instance v1, Larq$2;

    invoke-direct {v1, p0}, Larq$2;-><init>(Larq;)V

    invoke-direct {p0, p1, v0, v1, p2}, Larq;->a(Ljava/util/Set;Ljava/util/Set;Larr;Larp;)Larf;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized a(Ljava/lang/String;)V
    .locals 7

    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1}, Larq;->b(Ljava/lang/String;)V

    iget-object v0, p0, Larq;->b:Laqo;

    invoke-interface {v0, p1}, Laqo;->a(Ljava/lang/String;)Laqn;

    move-result-object v1

    invoke-interface {v1}, Laqn;->a()Lash;

    move-result-object v2

    iget-object v0, p0, Larq;->h:Ljava/util/Set;

    invoke-interface {v2}, Lash;->b()Larp;

    move-result-object v3

    invoke-virtual {p0, v0, v3}, Larq;->a(Ljava/util/Set;Larp;)Larf;

    move-result-object v0

    invoke-virtual {v0}, Larf;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Larn;

    iget-object v4, p0, Larq;->c:Ljava/util/Map;

    new-instance v5, Ljava/util/HashSet;

    invoke-direct {v5}, Ljava/util/HashSet;-><init>()V

    invoke-interface {v2}, Lash;->a()Lari;

    move-result-object v6

    invoke-direct {p0, v4, v0, v5, v6}, Larq;->a(Ljava/util/Map;Larn;Ljava/util/Set;Lari;)Larf;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_0
    :try_start_1
    invoke-interface {v1}, Laqn;->b()V

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Larq;->b(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-void
.end method

.method declared-synchronized b(Ljava/lang/String;)V
    .locals 1

    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Larq;->k:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
