.class public Lcom/wishabi/flipp/content/ShoppingList;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/wishabi/flipp/content/ShoppingList;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field a:Lcom/wishabi/flipp/util/l;

.field b:Landroid/database/Cursor;

.field public final c:I

.field public d:Landroid/content/Context;

.field public e:Lcom/wishabi/flipp/content/ar;

.field public f:J

.field public g:I

.field private final h:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lcom/wishabi/flipp/content/SimpleSearchResult;",
            ">;"
        }
    .end annotation
.end field

.field private i:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 68
    new-instance v0, Lcom/wishabi/flipp/content/ap;

    invoke-direct {v0}, Lcom/wishabi/flipp/content/ap;-><init>()V

    sput-object v0, Lcom/wishabi/flipp/content/ShoppingList;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 2

    .prologue
    .line 98
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->f:J

    .line 99
    iput p1, p0, Lcom/wishabi/flipp/content/ShoppingList;->c:I

    .line 100
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->h:Ljava/util/HashMap;

    .line 101
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 6

    .prologue
    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->f:J

    .line 104
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->c:I

    .line 105
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->f:J

    .line 106
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->h:Ljava/util/HashMap;

    .line 107
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 109
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_0

    .line 110
    iget-object v3, p0, Lcom/wishabi/flipp/content/ShoppingList;->h:Ljava/util/HashMap;

    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    const-class v0, Lcom/wishabi/flipp/content/SimpleSearchResult;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/SimpleSearchResult;

    invoke-virtual {v3, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 114
    :cond_0
    return-void
.end method

.method private a(Landroid/database/Cursor;)V
    .locals 4

    .prologue
    .line 348
    const-string v0, "_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    .line 350
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->i:Ljava/util/HashSet;

    .line 352
    invoke-interface {p1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    :goto_0
    if-eqz v0, :cond_0

    .line 353
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->i:Ljava/util/HashSet;

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 352
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    goto :goto_0

    .line 355
    :cond_0
    invoke-direct {p0}, Lcom/wishabi/flipp/content/ShoppingList;->d()V

    .line 356
    return-void
.end method

.method private a(Lcom/wishabi/flipp/content/az;Z)V
    .locals 4

    .prologue
    .line 373
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->h:Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/SimpleSearchResult;

    .line 375
    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/wishabi/flipp/content/ShoppingList;->i:Ljava/util/HashSet;

    if-eqz v1, :cond_1

    .line 376
    new-instance v1, Ljava/util/HashSet;

    iget-object v0, v0, Lcom/wishabi/flipp/content/SimpleSearchResult;->a:Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 377
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->i:Ljava/util/HashSet;

    invoke-virtual {v1, v0}, Ljava/util/HashSet;->retainAll(Ljava/util/Collection;)Z

    .line 378
    invoke-virtual {v1}, Ljava/util/HashSet;->size()I

    move-result v0

    iput v0, p1, Lcom/wishabi/flipp/content/az;->b:I

    .line 383
    :goto_0
    if-eqz p2, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    if-eqz v0, :cond_0

    .line 384
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    iget-object v1, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/wishabi/flipp/util/l;->c(J)I

    move-result v1

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/content/ar;->a(I)V

    .line 385
    :cond_0
    return-void

    .line 380
    :cond_1
    const/4 v0, -0x1

    iput v0, p1, Lcom/wishabi/flipp/content/az;->b:I

    goto :goto_0
.end method

.method private d()V
    .locals 5

    .prologue
    .line 359
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->i:Ljava/util/HashSet;

    if-nez v0, :cond_1

    .line 370
    :cond_0
    return-void

    .line 362
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/o;

    .line 363
    const/4 v1, 0x0

    move v2, v1

    :goto_0
    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->b()I

    move-result v1

    if-ge v2, v1, :cond_2

    .line 364
    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/util/o;->a(I)Lcom/wishabi/flipp/util/m;

    move-result-object v1

    iget-object v1, v1, Lcom/wishabi/flipp/util/m;->e:Ljava/lang/Object;

    check-cast v1, Lcom/wishabi/flipp/content/az;

    .line 367
    const/4 v4, 0x1

    invoke-direct {p0, v1, v4}, Lcom/wishabi/flipp/content/ShoppingList;->a(Lcom/wishabi/flipp/content/az;Z)V

    .line 363
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_0
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->b:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 122
    :cond_0
    const/4 v0, 0x0

    .line 124
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->c()I

    move-result v0

    goto :goto_0
.end method

.method public final a(I)I
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    if-nez v0, :cond_1

    .line 140
    :cond_0
    const/4 v0, -0x1

    .line 142
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    iget v0, v0, Lcom/wishabi/flipp/util/m;->d:I

    goto :goto_0
.end method

.method public final a(J)I
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    if-nez v0, :cond_0

    .line 161
    const/4 v0, -0x1

    .line 163
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1, p2}, Lcom/wishabi/flipp/util/l;->c(J)I

    move-result v0

    goto :goto_0
.end method

.method public final a(Lcom/wishabi/flipp/content/az;)I
    .locals 4

    .prologue
    .line 153
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    if-eqz v0, :cond_0

    if-nez p1, :cond_1

    .line 154
    :cond_0
    const/4 v0, -0x1

    .line 156
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/wishabi/flipp/util/l;->a(J)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    iget v0, v0, Lcom/wishabi/flipp/util/m;->c:I

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;)Landroid/net/Uri;
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 431
    if-eqz p1, :cond_0

    const-string v0, ""

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 432
    :cond_0
    const/4 v0, 0x0

    .line 443
    :goto_0
    return-object v0

    .line 434
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 436
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 437
    const-string v2, "name"

    invoke-virtual {v1, v2, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 438
    const-string v2, "position"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 439
    const-string v2, "checked"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 440
    const-string v2, "datetime_updated"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 441
    const-string v2, "shopping_list_id"

    iget v3, p0, Lcom/wishabi/flipp/content/ShoppingList;->c:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 443
    sget-object v2, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    invoke-virtual {v0, v2, v1}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0
.end method

.method public final a(JLcom/wishabi/flipp/content/SimpleSearchResult;)V
    .locals 3

    .prologue
    .line 327
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->h:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 328
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/content/ShoppingList;->b(J)Lcom/wishabi/flipp/content/az;

    move-result-object v0

    .line 330
    if-nez v0, :cond_0

    .line 334
    :goto_0
    return-void

    .line 333
    :cond_0
    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lcom/wishabi/flipp/content/ShoppingList;->a(Lcom/wishabi/flipp/content/az;Z)V

    goto :goto_0
.end method

.method public final b()I
    .locals 2

    .prologue
    .line 128
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->b:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 129
    :cond_0
    const/4 v0, 0x0

    .line 131
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->c()I

    move-result v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    iget-object v1, v1, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    sub-int/2addr v0, v1

    goto :goto_0
.end method

.method public final b(J)Lcom/wishabi/flipp/content/az;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1, p2}, Lcom/wishabi/flipp/util/l;->a(J)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    if-nez v0, :cond_1

    .line 175
    :cond_0
    const/4 v0, 0x0

    .line 177
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1, p2}, Lcom/wishabi/flipp/util/l;->b(J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/az;

    goto :goto_0
.end method

.method public final b(I)Ljava/lang/String;
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 181
    iget-object v1, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    if-nez v1, :cond_1

    .line 189
    :cond_0
    :goto_0
    return-object v0

    .line 184
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, p1}, Lcom/wishabi/flipp/util/l;->c(I)Lcom/wishabi/flipp/util/o;

    move-result-object v1

    .line 186
    if-eqz v1, :cond_0

    .line 189
    iget-object v0, v1, Lcom/wishabi/flipp/util/o;->e:Ljava/lang/String;

    goto :goto_0
.end method

.method public final b(Lcom/wishabi/flipp/content/az;)V
    .locals 8

    .prologue
    .line 447
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 448
    sget-object v1, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    const-string v2, "id = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 450
    return-void
.end method

.method public final c(J)Lcom/wishabi/flipp/content/SimpleSearchResult;
    .locals 3

    .prologue
    .line 323
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->h:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/SimpleSearchResult;

    return-object v0
.end method

.method public final c()V
    .locals 1

    .prologue
    .line 342
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 343
    invoke-direct {p0}, Lcom/wishabi/flipp/content/ShoppingList;->d()V

    .line 344
    return-void
.end method

.method public final d(J)V
    .locals 3

    .prologue
    .line 337
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->h:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 338
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/content/ShoppingList;->b(J)Lcom/wishabi/flipp/content/az;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wishabi/flipp/content/ShoppingList;->a(Lcom/wishabi/flipp/content/az;Z)V

    .line 339
    return-void
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 83
    const/4 v0, 0x0

    return v0
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 390
    packed-switch p1, :pswitch_data_0

    .line 401
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Invalid loader requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 392
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    sget-object v2, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/String;

    const-string v4, "*"

    aput-object v4, v3, v7

    const-string v4, "category"

    aput-object v4, v3, v6

    const/4 v4, 0x2

    const-string v5, "cat_position"

    aput-object v5, v3, v4

    const-string v4, "shopping_list_id = ?"

    new-array v5, v6, [Ljava/lang/String;

    iget v6, p0, Lcom/wishabi/flipp/content/ShoppingList;->c:I

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    const-string v6, "cat_position ASC, LOWER(name) ASC, id ASC"

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 398
    :goto_0
    return-object v0

    :pswitch_1
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    sget-object v2, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    new-array v3, v6, [Ljava/lang/String;

    const-string v5, "_id"

    aput-object v5, v3, v7

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 390
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 20

    .prologue
    .line 31
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual/range {p1 .. p1}, Landroid/content/Loader;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    new-instance v2, Ljava/security/InvalidParameterException;

    const-string v3, "Invalid loader requested"

    invoke-direct {v2, v3}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v2

    :pswitch_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->b:Landroid/database/Cursor;

    move-object/from16 v0, p2

    if-ne v2, v0, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    invoke-interface {v2}, Lcom/wishabi/flipp/content/ar;->a()V

    :cond_0
    :goto_0
    return-void

    :cond_1
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->b:Landroid/database/Cursor;

    if-eqz v2, :cond_8

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->b:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_8

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->b:Landroid/database/Cursor;

    move-object v4, v2

    :goto_1
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->g:I

    new-instance v10, Lcom/wishabi/flipp/util/l;

    invoke-direct {v10}, Lcom/wishabi/flipp/util/l;-><init>()V

    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    new-instance v12, Ljava/util/ArrayList;

    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v4}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-gtz v2, :cond_2

    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_10

    :cond_2
    const-string v2, "id"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v14

    new-instance v2, Lcom/wishabi/flipp/util/b;

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "cat_position"

    aput-object v6, v3, v5

    const/4 v5, 0x1

    const-string v6, "name"

    aput-object v6, v3, v5

    const/4 v5, 0x2

    const-string v6, "id"

    aput-object v6, v3, v5

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "cat_position"

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const-string v7, "name"

    aput-object v7, v5, v6

    const/4 v6, 0x2

    const-string v7, "id"

    aput-object v7, v5, v6

    move-object/from16 v0, p2

    invoke-direct {v2, v4, v3, v0, v5}, Lcom/wishabi/flipp/util/b;-><init>(Landroid/database/Cursor;[Ljava/lang/String;Landroid/database/Cursor;[Ljava/lang/String;)V

    const/4 v6, -0x1

    const/4 v5, 0x0

    invoke-virtual {v2}, Lcom/wishabi/flipp/util/b;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :cond_3
    :goto_2
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_f

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/util/d;

    sget-object v3, Lcom/wishabi/flipp/content/aq;->a:[I

    invoke-virtual {v2}, Lcom/wishabi/flipp/util/d;->ordinal()I

    move-result v7

    aget v3, v3, v7

    packed-switch v3, :pswitch_data_1

    goto :goto_2

    :pswitch_1
    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v16

    if-eqz v9, :cond_9

    move-wide/from16 v0, v16

    invoke-virtual {v9, v0, v1}, Lcom/wishabi/flipp/util/l;->b(J)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/wishabi/flipp/content/az;

    move-object v8, v3

    :goto_3
    if-eqz v8, :cond_a

    new-instance v3, Lcom/wishabi/flipp/content/az;

    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->getPosition()I

    move-result v7

    move-object/from16 v0, p2

    invoke-direct {v3, v8, v0, v7}, Lcom/wishabi/flipp/content/az;-><init>(Lcom/wishabi/flipp/content/az;Landroid/database/Cursor;I)V

    move-object v7, v3

    :goto_4
    sget-object v3, Lcom/wishabi/flipp/util/d;->a:Lcom/wishabi/flipp/util/d;

    if-ne v2, v3, :cond_b

    invoke-virtual {v11, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/4 v2, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v7, v2}, Lcom/wishabi/flipp/content/ShoppingList;->a(Lcom/wishabi/flipp/content/az;Z)V

    :cond_4
    :goto_5
    invoke-virtual {v7}, Lcom/wishabi/flipp/content/az;->c()Z

    move-result v2

    if-eqz v2, :cond_5

    move-object/from16 v0, p0

    iget v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->g:I

    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->g:I

    :cond_5
    invoke-virtual {v7}, Lcom/wishabi/flipp/content/az;->d()I

    move-result v3

    if-eqz v5, :cond_6

    if-eq v3, v6, :cond_17

    :cond_6
    if-eqz v5, :cond_7

    invoke-virtual {v10, v5}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    :cond_7
    const/16 v2, 0x3e8

    if-ne v3, v2, :cond_c

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->d:Landroid/content/Context;

    const v5, 0x7f0e0024

    invoke-virtual {v2, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    move-object v5, v2

    :goto_6
    rsub-int/lit8 v6, v3, -0x2

    new-instance v2, Lcom/wishabi/flipp/util/o;

    invoke-direct {v2, v6, v5}, Lcom/wishabi/flipp/util/o;-><init>(ILjava/lang/String;)V

    new-instance v8, Lcom/wishabi/flipp/util/m;

    int-to-long v0, v6

    move-wide/from16 v18, v0

    const/4 v6, 0x1

    move-wide/from16 v0, v18

    invoke-direct {v8, v0, v1, v6, v5}, Lcom/wishabi/flipp/util/m;-><init>(JILjava/lang/Object;)V

    invoke-virtual {v2, v8}, Lcom/wishabi/flipp/util/o;->a(Lcom/wishabi/flipp/util/m;)V

    :goto_7
    new-instance v5, Lcom/wishabi/flipp/util/m;

    const/4 v6, 0x0

    move-wide/from16 v0, v16

    invoke-direct {v5, v0, v1, v6, v7}, Lcom/wishabi/flipp/util/m;-><init>(JILjava/lang/Object;)V

    invoke-virtual {v2, v5}, Lcom/wishabi/flipp/util/o;->b(Lcom/wishabi/flipp/util/m;)V

    move-object v5, v2

    move v6, v3

    goto/16 :goto_2

    :cond_8
    new-instance v2, Landroid/database/MatrixCursor;

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "cat_position"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string v5, "name"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string v5, "id"

    aput-object v5, v3, v4

    invoke-direct {v2, v3}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    move-object v4, v2

    goto/16 :goto_1

    :cond_9
    const/4 v3, 0x0

    move-object v8, v3

    goto/16 :goto_3

    :cond_a
    new-instance v3, Lcom/wishabi/flipp/content/az;

    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->getPosition()I

    move-result v7

    move-object/from16 v0, p2

    invoke-direct {v3, v0, v7}, Lcom/wishabi/flipp/content/az;-><init>(Landroid/database/Cursor;I)V

    move-object v7, v3

    goto/16 :goto_4

    :cond_b
    if-eqz v8, :cond_4

    invoke-virtual {v8}, Lcom/wishabi/flipp/content/az;->e()J

    move-result-wide v2

    invoke-virtual {v7}, Lcom/wishabi/flipp/content/az;->e()J

    move-result-wide v18

    cmp-long v2, v2, v18

    if-eqz v2, :cond_4

    invoke-virtual {v12, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_5

    :cond_c
    sget v2, Lcom/wishabi/flipp/content/az;->a:I

    const/4 v5, -0x1

    if-ne v2, v5, :cond_d

    new-instance v2, Ljava/lang/IllegalAccessError;

    const-string v3, "Trying to grab category for ShoppingListItem without joining on the query"

    invoke-direct {v2, v3}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_d
    invoke-virtual {v7}, Lcom/wishabi/flipp/content/az;->f()V

    iget-object v2, v7, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    sget v5, Lcom/wishabi/flipp/content/az;->a:I

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7}, Lcom/wishabi/flipp/content/az;->g()V

    move-object v5, v2

    goto :goto_6

    :pswitch_2
    invoke-interface {v4, v14}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    if-nez v9, :cond_e

    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "Item removed but old items no longer in memory"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_e
    invoke-virtual {v9, v2, v3}, Lcom/wishabi/flipp/util/l;->b(J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/content/az;

    if-eqz v2, :cond_3

    invoke-virtual {v13, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_2

    :cond_f
    if-eqz v5, :cond_10

    invoke-virtual {v10, v5}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    :cond_10
    move-object/from16 v0, p0

    iput-object v10, v0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    move-object/from16 v0, p2

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/wishabi/flipp/content/ShoppingList;->b:Landroid/database/Cursor;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    if-eqz v2, :cond_0

    if-nez v9, :cond_11

    invoke-direct/range {p0 .. p0}, Lcom/wishabi/flipp/content/ShoppingList;->d()V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    move-object/from16 v0, p0

    invoke-interface {v2, v0}, Lcom/wishabi/flipp/content/ar;->a(Lcom/wishabi/flipp/content/ShoppingList;)V

    goto/16 :goto_0

    :cond_11
    invoke-virtual {v11}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/2addr v2, v3

    const/4 v3, 0x1

    if-le v2, v3, :cond_12

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    move-object/from16 v0, p0

    invoke-interface {v2, v0}, Lcom/wishabi/flipp/content/ar;->a(Lcom/wishabi/flipp/content/ShoppingList;)V

    goto/16 :goto_0

    :cond_12
    invoke-virtual {v11}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_8
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_14

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/content/az;

    invoke-virtual {v2}, Lcom/wishabi/flipp/content/az;->d()I

    move-result v3

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/content/ShoppingList;->a(Lcom/wishabi/flipp/content/az;)I

    move-result v6

    rsub-int/lit8 v3, v3, -0x2

    invoke-virtual {v9, v3}, Lcom/wishabi/flipp/util/l;->a(I)Lcom/wishabi/flipp/util/o;

    move-result-object v3

    if-nez v3, :cond_13

    const/4 v3, 0x1

    :goto_9
    invoke-interface {v5, v2, v6, v3}, Lcom/wishabi/flipp/content/ar;->a(Lcom/wishabi/flipp/content/az;IZ)V

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, "Added "

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_8

    :cond_13
    const/4 v3, 0x0

    goto :goto_9

    :cond_14
    invoke-virtual {v13}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_a
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_16

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/content/az;

    invoke-virtual {v2}, Lcom/wishabi/flipp/content/az;->d()I

    move-result v3

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    invoke-virtual {v2}, Lcom/wishabi/flipp/content/az;->a()J

    move-result-wide v6

    invoke-virtual {v9, v6, v7}, Lcom/wishabi/flipp/util/l;->c(J)I

    move-result v6

    rsub-int/lit8 v3, v3, -0x2

    invoke-virtual {v10, v3}, Lcom/wishabi/flipp/util/l;->a(I)Lcom/wishabi/flipp/util/o;

    move-result-object v3

    if-nez v3, :cond_15

    const/4 v3, 0x1

    :goto_b
    invoke-interface {v5, v2, v6, v3}, Lcom/wishabi/flipp/content/ar;->b(Lcom/wishabi/flipp/content/az;IZ)V

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, "Removed "

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_a

    :cond_15
    const/4 v3, 0x0

    goto :goto_b

    :cond_16
    invoke-virtual {v12}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_c
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/content/az;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/content/ShoppingList;->a(Lcom/wishabi/flipp/content/az;)I

    move-result v5

    invoke-interface {v4, v5}, Lcom/wishabi/flipp/content/ar;->a(I)V

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Edited "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/wishabi/flipp/content/az;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_c

    :pswitch_3
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/content/ShoppingList;->a(Landroid/database/Cursor;)V

    goto/16 :goto_0

    :cond_17
    move-object v2, v5

    move v3, v6

    goto/16 :goto_7

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_3
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 422
    iput-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->a:Lcom/wishabi/flipp/util/l;

    .line 423
    iput-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->b:Landroid/database/Cursor;

    .line 424
    iput-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->i:Ljava/util/HashSet;

    .line 426
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    if-eqz v0, :cond_0

    .line 427
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->e:Lcom/wishabi/flipp/content/ar;

    invoke-interface {v0, p0}, Lcom/wishabi/flipp/content/ar;->a(Lcom/wishabi/flipp/content/ShoppingList;)V

    .line 428
    :cond_0
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 6

    .prologue
    .line 88
    iget v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->c:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 89
    iget-wide v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->f:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 90
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 91
    iget-object v0, p0, Lcom/wishabi/flipp/content/ShoppingList;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 92
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-virtual {p1, v4, v5}, Landroid/os/Parcel;->writeLong(J)V

    .line 93
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Parcelable;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    goto :goto_0

    .line 96
    :cond_0
    return-void
.end method
