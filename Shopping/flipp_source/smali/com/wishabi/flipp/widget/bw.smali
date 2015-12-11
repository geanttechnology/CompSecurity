.class public Lcom/wishabi/flipp/widget/bw;
.super Lcom/wishabi/flipp/widget/cz;
.source "SourceFile"


# static fields
.field private static final a:I

.field private static final e:I

.field private static final f:I

.field private static final v:Lb/a/a/i;


# instance fields
.field public final b:Z

.field public final c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/widget/by;",
            ">;"
        }
    .end annotation
.end field

.field private final g:Landroid/util/SparseBooleanArray;

.field private final h:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/h;",
            ">;"
        }
    .end annotation
.end field

.field private final i:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private final k:I

.field private final l:I

.field private final m:I

.field private final n:I

.field private final o:I

.field private final p:I

.field private final q:I

.field private final r:I

.field private final s:Lcom/wishabi/flipp/widget/cb;

.field private final t:Lcom/wishabi/flipp/widget/ec;

.field private final u:Lcom/wishabi/flipp/widget/bc;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    invoke-static {}, Lcom/wishabi/flipp/widget/cb;->values()[Lcom/wishabi/flipp/widget/cb;

    move-result-object v0

    array-length v0, v0

    sput v0, Lcom/wishabi/flipp/widget/bw;->a:I

    .line 45
    invoke-static {}, Lcom/wishabi/flipp/widget/ca;->a()[I

    move-result-object v0

    array-length v0, v0

    sput v0, Lcom/wishabi/flipp/widget/bw;->e:I

    .line 53
    invoke-static {}, Lcom/wishabi/flipp/widget/cc;->a()[I

    move-result-object v0

    array-length v0, v0

    sput v0, Lcom/wishabi/flipp/widget/bw;->f:I

    .line 123
    const-string v0, "America/Toronto"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Lb/a/a/i;->a(Ljava/util/TimeZone;)Lb/a/a/i;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/widget/bw;->v:Lb/a/a/i;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/util/SparseBooleanArray;Ljava/util/List;Lcom/wishabi/flipp/widget/cb;ZLcom/wishabi/flipp/widget/ec;Lcom/wishabi/flipp/widget/bc;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/database/Cursor;",
            "Landroid/util/SparseBooleanArray;",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/h;",
            ">;",
            "Lcom/wishabi/flipp/widget/cb;",
            "Z",
            "Lcom/wishabi/flipp/widget/ec;",
            "Lcom/wishabi/flipp/widget/bc;",
            ")V"
        }
    .end annotation

    .prologue
    .line 134
    invoke-direct {p0, p1, p2}, Lcom/wishabi/flipp/widget/cz;-><init>(Landroid/content/Context;Landroid/database/Cursor;)V

    .line 136
    iput-object p3, p0, Lcom/wishabi/flipp/widget/bw;->g:Landroid/util/SparseBooleanArray;

    .line 137
    iput-object p4, p0, Lcom/wishabi/flipp/widget/bw;->h:Ljava/util/List;

    .line 138
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bw;->i:Ljava/util/HashMap;

    .line 139
    const-string v0, "name"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/bw;->k:I

    .line 140
    const-string v0, "thumbnail"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/bw;->l:I

    .line 141
    const-string v0, "valid_from"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/bw;->m:I

    .line 142
    const-string v0, "valid_to"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/bw;->n:I

    .line 143
    const-string v0, "merchant"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/bw;->o:I

    .line 144
    const-string v0, "flyer_id"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/bw;->p:I

    .line 145
    const-string v0, "premium"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/bw;->q:I

    .line 146
    iput-object p5, p0, Lcom/wishabi/flipp/widget/bw;->s:Lcom/wishabi/flipp/widget/cb;

    .line 147
    iput-boolean p6, p0, Lcom/wishabi/flipp/widget/bw;->b:Z

    .line 148
    iput-object p7, p0, Lcom/wishabi/flipp/widget/bw;->t:Lcom/wishabi/flipp/widget/ec;

    .line 149
    iput-object p8, p0, Lcom/wishabi/flipp/widget/bw;->u:Lcom/wishabi/flipp/widget/bc;

    .line 150
    invoke-direct {p0, p5, p2, p6}, Lcom/wishabi/flipp/widget/bw;->a(Lcom/wishabi/flipp/widget/cb;Landroid/database/Cursor;Z)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/bw;->c:Ljava/util/ArrayList;

    .line 151
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/bw;->r:I

    .line 153
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 154
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/by;

    .line 155
    iget v0, v0, Lcom/wishabi/flipp/widget/by;->b:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 157
    :cond_0
    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/bw;->a(Ljava/util/List;)V

    .line 158
    return-void
.end method

.method static synthetic a()I
    .locals 1

    .prologue
    .line 31
    sget v0, Lcom/wishabi/flipp/widget/bw;->a:I

    return v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/bw;)Lcom/wishabi/flipp/widget/cb;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->s:Lcom/wishabi/flipp/widget/cb;

    return-object v0
.end method

.method public static final a(Lcom/wishabi/flipp/widget/cb;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 90
    sget-object v0, Lcom/wishabi/flipp/widget/bx;->a:[I

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/cb;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 100
    const-string v0, "premium DESC, priority ASC, available_from DESC"

    :goto_0
    return-object v0

    .line 92
    :pswitch_0
    const-string v0, "premium DESC, priority ASC, available_from DESC"

    goto :goto_0

    .line 94
    :pswitch_1
    const-string v0, "merchant COLLATE NOCASE ASC, name COLLATE NOCASE ASC, flyer_id DESC"

    goto :goto_0

    .line 97
    :pswitch_2
    const-string v0, "available_from DESC, priority ASC, merchant COLLATE NOCASE ASC, flyer_id DESC"

    goto :goto_0

    .line 90
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private a(Lcom/wishabi/flipp/widget/cb;Landroid/database/Cursor;Z)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wishabi/flipp/widget/cb;",
            "Landroid/database/Cursor;",
            "Z)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/widget/by;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 167
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 169
    if-eqz p3, :cond_0

    .line 170
    new-instance v0, Lcom/wishabi/flipp/widget/by;

    sget v3, Lcom/wishabi/flipp/widget/ca;->a:I

    sget v4, Lcom/wishabi/flipp/widget/cc;->b:I

    sget v5, Lcom/wishabi/flipp/widget/cc;->d:I

    invoke-direct {v0, v3, v1, v4, v5}, Lcom/wishabi/flipp/widget/by;-><init>(IIII)V

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 173
    :cond_0
    sget-object v0, Lcom/wishabi/flipp/widget/bx;->a:[I

    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/cb;->ordinal()I

    move-result v3

    aget v0, v0, v3

    packed-switch v0, :pswitch_data_0

    .line 196
    :cond_1
    :goto_0
    return-object v2

    .line 177
    :pswitch_0
    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    :goto_1
    if-eqz v0, :cond_2

    .line 178
    iget v0, p0, Lcom/wishabi/flipp/widget/bw;->q:I

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-eqz v0, :cond_2

    .line 179
    add-int/lit8 v1, v1, 0x1

    .line 177
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    goto :goto_1

    .line 183
    :cond_2
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    sub-int/2addr v0, v1

    .line 185
    if-lez v1, :cond_3

    .line 186
    new-instance v3, Lcom/wishabi/flipp/widget/by;

    sget v4, Lcom/wishabi/flipp/widget/ca;->b:I

    sget v5, Lcom/wishabi/flipp/widget/cc;->a:I

    sget v6, Lcom/wishabi/flipp/widget/cc;->c:I

    invoke-direct {v3, v4, v1, v5, v6}, Lcom/wishabi/flipp/widget/by;-><init>(IIII)V

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 188
    :cond_3
    if-lez v0, :cond_1

    .line 189
    new-instance v1, Lcom/wishabi/flipp/widget/by;

    sget v3, Lcom/wishabi/flipp/widget/ca;->c:I

    sget v4, Lcom/wishabi/flipp/widget/cc;->b:I

    sget v5, Lcom/wishabi/flipp/widget/cc;->c:I

    invoke-direct {v1, v3, v0, v4, v5}, Lcom/wishabi/flipp/widget/by;-><init>(IIII)V

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 194
    :pswitch_1
    new-instance v0, Lcom/wishabi/flipp/widget/by;

    sget v1, Lcom/wishabi/flipp/widget/ca;->c:I

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v3

    sget v4, Lcom/wishabi/flipp/widget/cc;->b:I

    sget v5, Lcom/wishabi/flipp/widget/cc;->c:I

    invoke-direct {v0, v1, v3, v4, v5}, Lcom/wishabi/flipp/widget/by;-><init>(IIII)V

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 173
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public final a(II)I
    .locals 1

    .prologue
    .line 366
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/widget/bw;->b(II)I

    move-result v0

    return v0
.end method

.method protected final a(Landroid/content/Context;ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 288
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/by;

    .line 290
    sget-object v2, Lcom/wishabi/flipp/widget/bx;->b:[I

    iget v0, v0, Lcom/wishabi/flipp/widget/by;->a:I

    add-int/lit8 v0, v0, -0x1

    aget v0, v2, v0

    packed-switch v0, :pswitch_data_0

    .line 305
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/widget/bw;->a(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v2

    .line 307
    if-nez v2, :cond_1

    move-object p3, v1

    .line 323
    :cond_0
    :goto_0
    return-object p3

    .line 295
    :pswitch_0
    if-nez p3, :cond_0

    .line 298
    new-instance v0, Lcom/wishabi/flipp/widget/dz;

    invoke-direct {v0, p1}, Lcom/wishabi/flipp/widget/dz;-><init>(Landroid/content/Context;)V

    .line 299
    new-instance v1, Lcom/wishabi/flipp/widget/bz;

    invoke-direct {v1, p0, p1}, Lcom/wishabi/flipp/widget/bz;-><init>(Lcom/wishabi/flipp/widget/bw;Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/dz;->setTabAdapter(Lcom/wishabi/flipp/widget/eb;)V

    .line 300
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bw;->t:Lcom/wishabi/flipp/widget/ec;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/dz;->setTabClickListener(Lcom/wishabi/flipp/widget/ec;)V

    :goto_1
    move-object p3, v0

    .line 323
    goto :goto_0

    .line 310
    :cond_1
    check-cast p3, Landroid/widget/TextView;

    .line 311
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 312
    if-nez p3, :cond_3

    .line 313
    const v3, 0x7f03002b

    const/4 v4, 0x0

    invoke-virtual {v0, v3, p4, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 316
    :goto_2
    if-nez v0, :cond_2

    move-object p3, v1

    .line 317
    goto :goto_0

    .line 319
    :cond_2
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    :cond_3
    move-object v0, p3

    goto :goto_2

    .line 290
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method protected final a(Landroid/content/Context;Landroid/database/Cursor;ILandroid/view/View;)Landroid/view/View;
    .locals 10

    .prologue
    .line 207
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v0

    const-string v1, "fr"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 208
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p0, Lcom/wishabi/flipp/widget/bw;->k:I

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/widget/bw;->o:I

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 214
    :goto_0
    iget v1, p0, Lcom/wishabi/flipp/widget/bw;->p:I

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    .line 215
    iget v1, p0, Lcom/wishabi/flipp/widget/bw;->m:I

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 216
    iget v3, p0, Lcom/wishabi/flipp/widget/bw;->n:I

    invoke-interface {p2, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 217
    invoke-static {}, Lb/a/a/d/aa;->a()Lb/a/a/d/d;

    move-result-object v4

    .line 218
    invoke-virtual {v4, v1}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v5

    .line 219
    invoke-virtual {v4, v3}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v4

    .line 220
    sget-object v6, Lcom/wishabi/flipp/widget/bw;->v:Lb/a/a/i;

    invoke-static {v6}, Lb/a/a/b;->a(Lb/a/a/i;)Lb/a/a/b;

    move-result-object v6

    .line 221
    iget v7, p0, Lcom/wishabi/flipp/widget/bw;->l:I

    invoke-interface {p2, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 223
    invoke-virtual {p0, p3}, Lcom/wishabi/flipp/widget/bw;->c(I)I

    move-result v8

    sget v9, Lcom/wishabi/flipp/widget/cc;->a:I

    add-int/lit8 v9, v9, -0x1

    if-ne v8, v9, :cond_d

    .line 224
    if-eqz p4, :cond_6

    check-cast p4, Lcom/wishabi/flipp/widget/ba;

    .line 226
    :goto_1
    invoke-virtual {p4, v0}, Lcom/wishabi/flipp/widget/ba;->setFlyerName(Ljava/lang/String;)V

    .line 228
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->g:Landroid/util/SparseBooleanArray;

    if-eqz v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->g:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, v2}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v0

    if-nez v0, :cond_7

    const/4 v0, 0x1

    :goto_2
    invoke-virtual {p4, v0}, Lcom/wishabi/flipp/widget/ba;->setUnread(Z)V

    .line 230
    :cond_0
    invoke-virtual {v6, v5}, Lb/a/a/b;->a(Lb/a/a/z;)I

    move-result v0

    if-gez v0, :cond_8

    const/4 v0, 0x1

    :goto_3
    invoke-virtual {p4, v0}, Lcom/wishabi/flipp/widget/ba;->setUpcoming(Z)V

    .line 231
    invoke-virtual {p4, v7}, Lcom/wishabi/flipp/widget/ba;->setThumbnailUrl(Ljava/lang/String;)V

    .line 233
    if-eqz v1, :cond_1

    if-eqz v3, :cond_1

    .line 234
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-static {v0, v5, v6, v4}, Lcom/wishabi/flipp/util/e;->a(Landroid/content/res/Resources;Lb/a/a/b;Lb/a/a/b;Lb/a/a/b;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p4, v0}, Lcom/wishabi/flipp/widget/ba;->setFlyerDate(Ljava/lang/String;)V

    .line 237
    :cond_1
    const/4 v1, 0x0

    .line 238
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->h:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/h;

    .line 239
    iget v4, v0, Lcom/wishabi/flipp/content/h;->b:I

    if-ne v2, v4, :cond_2

    move-object v1, v0

    .line 245
    :cond_3
    if-nez v1, :cond_9

    .line 246
    iget-object v0, p4, Lcom/wishabi/flipp/widget/ba;->a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->setData(Lcom/wishabi/flipp/content/h;)V

    iget-object v0, p4, Lcom/wishabi/flipp/widget/ba;->a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->a()V

    .line 247
    const/4 v0, 0x0

    invoke-virtual {p4, v0}, Lcom/wishabi/flipp/widget/ba;->setFeaturedItemClickListener(Lcom/wishabi/flipp/widget/bc;)V

    .line 280
    :cond_4
    :goto_4
    return-object p4

    .line 211
    :cond_5
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p0, Lcom/wishabi/flipp/widget/bw;->o:I

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/widget/bw;->k:I

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 224
    :cond_6
    new-instance p4, Lcom/wishabi/flipp/widget/ba;

    invoke-direct {p4, p1}, Lcom/wishabi/flipp/widget/ba;-><init>(Landroid/content/Context;)V

    goto/16 :goto_1

    .line 229
    :cond_7
    const/4 v0, 0x0

    goto :goto_2

    .line 230
    :cond_8
    const/4 v0, 0x0

    goto :goto_3

    .line 249
    :cond_9
    iget-wide v2, v1, Lcom/wishabi/flipp/content/h;->a:J

    .line 251
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->i:Ljava/util/HashMap;

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 252
    if-nez v0, :cond_a

    .line 253
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 254
    :cond_a
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_b

    const/4 v0, 0x1

    :goto_5
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 256
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    iget-object v5, p4, Lcom/wishabi/flipp/widget/ba;->a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

    invoke-virtual {v5, v1}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->setData(Lcom/wishabi/flipp/content/h;)V

    iget-object v1, p4, Lcom/wishabi/flipp/widget/ba;->a:Lcom/wishabi/flipp/widget/FeaturedItemCell;

    iget-object v5, v1, Lcom/wishabi/flipp/widget/FeaturedItemCell;->a:Landroid/animation/Animator;

    invoke-virtual {v5}, Landroid/animation/Animator;->cancel()V

    const/4 v5, 0x0

    invoke-virtual {v1, v5}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->setVisibility(I)V

    if-eqz v4, :cond_c

    iget-object v1, v1, Lcom/wishabi/flipp/widget/FeaturedItemCell;->a:Landroid/animation/Animator;

    invoke-virtual {v1}, Landroid/animation/Animator;->start()V

    :goto_6
    invoke-virtual {p4}, Lcom/wishabi/flipp/widget/ba;->a()V

    .line 257
    iget-object v1, p0, Lcom/wishabi/flipp/widget/bw;->u:Lcom/wishabi/flipp/widget/bc;

    invoke-virtual {p4, v1}, Lcom/wishabi/flipp/widget/ba;->setFeaturedItemClickListener(Lcom/wishabi/flipp/widget/bc;)V

    .line 260
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 261
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->i:Ljava/util/HashMap;

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_4

    .line 254
    :cond_b
    const/4 v0, 0x0

    goto :goto_5

    .line 256
    :cond_c
    const/high16 v4, 0x3f800000    # 1.0f

    invoke-virtual {v1, v4}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->setAlpha(F)V

    const/4 v4, 0x0

    invoke-virtual {v1, v4}, Lcom/wishabi/flipp/widget/FeaturedItemCell;->setXFraction(F)V

    goto :goto_6

    .line 266
    :cond_d
    if-eqz p4, :cond_f

    check-cast p4, Lcom/wishabi/flipp/widget/az;

    .line 268
    :goto_7
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v8, p0, Lcom/wishabi/flipp/widget/bw;->o:I

    invoke-interface {p2, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v8, " "

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v8, p0, Lcom/wishabi/flipp/widget/bw;->k:I

    invoke-interface {p2, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p4, v0}, Lcom/wishabi/flipp/widget/az;->setFlyerName(Ljava/lang/String;)V

    .line 271
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->g:Landroid/util/SparseBooleanArray;

    if-eqz v0, :cond_e

    .line 272
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->g:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, v2}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v0

    if-nez v0, :cond_10

    const/4 v0, 0x1

    :goto_8
    invoke-virtual {p4, v0}, Lcom/wishabi/flipp/widget/az;->setUnread(Z)V

    .line 273
    :cond_e
    invoke-virtual {v6, v5}, Lb/a/a/b;->a(Lb/a/a/z;)I

    move-result v0

    if-gez v0, :cond_11

    const/4 v0, 0x1

    :goto_9
    invoke-virtual {p4, v0}, Lcom/wishabi/flipp/widget/az;->setUpcoming(Z)V

    .line 274
    invoke-virtual {p4, v7}, Lcom/wishabi/flipp/widget/az;->setThumbnailUrl(Ljava/lang/String;)V

    .line 276
    if-eqz v1, :cond_4

    if-eqz v3, :cond_4

    .line 277
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-static {v0, v5, v6, v4}, Lcom/wishabi/flipp/util/e;->a(Landroid/content/res/Resources;Lb/a/a/b;Lb/a/a/b;Lb/a/a/b;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p4, v0}, Lcom/wishabi/flipp/widget/az;->setFlyerDate(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 266
    :cond_f
    new-instance p4, Lcom/wishabi/flipp/widget/az;

    invoke-direct {p4, p1}, Lcom/wishabi/flipp/widget/az;-><init>(Landroid/content/Context;)V

    goto :goto_7

    .line 272
    :cond_10
    const/4 v0, 0x0

    goto :goto_8

    .line 273
    :cond_11
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public a(Landroid/content/Context;I)Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v2, 0x1

    .line 347
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 349
    const/4 v0, 0x0

    .line 353
    iget-boolean v1, p0, Lcom/wishabi/flipp/widget/bw;->b:Z

    if-eqz v1, :cond_0

    if-eq p2, v2, :cond_1

    :cond_0
    if-nez p2, :cond_2

    .line 354
    :cond_1
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e0012

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget v4, p0, Lcom/wishabi/flipp/widget/da;->j:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 356
    :cond_2
    return-object v0
.end method

.method public final b(I)I
    .locals 1

    .prologue
    .line 380
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/by;

    iget v0, v0, Lcom/wishabi/flipp/widget/by;->a:I

    return v0
.end method

.method protected final c(I)I
    .locals 1

    .prologue
    .line 328
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/by;

    .line 330
    iget v0, v0, Lcom/wishabi/flipp/widget/by;->c:I

    add-int/lit8 v0, v0, -0x1

    return v0
.end method

.method protected final d(I)I
    .locals 1

    .prologue
    .line 336
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/by;

    .line 337
    iget v0, v0, Lcom/wishabi/flipp/widget/by;->d:I

    add-int/lit8 v0, v0, -0x1

    return v0
.end method

.method public final e(I)I
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 384
    .line 385
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bw;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v1, v2

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/by;

    .line 386
    iget v4, v0, Lcom/wishabi/flipp/widget/by;->b:I

    add-int/2addr v1, v4

    .line 387
    if-ge p1, v1, :cond_0

    .line 388
    iget v2, v0, Lcom/wishabi/flipp/widget/by;->a:I

    .line 390
    :cond_1
    return v2
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 342
    sget v0, Lcom/wishabi/flipp/widget/bw;->f:I

    return v0
.end method
