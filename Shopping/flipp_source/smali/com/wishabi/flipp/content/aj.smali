.class public Lcom/wishabi/flipp/content/aj;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final a:Ljava/lang/String;

.field public static final b:Landroid/net/Uri;

.field public static final c:Landroid/net/Uri;

.field public static final d:Landroid/net/Uri;

.field public static final e:[Ljava/lang/String;

.field public static final f:[Ljava/lang/String;

.field public static final g:[Ljava/lang/String;

.field public static final h:[Ljava/lang/String;

.field public static final i:[Ljava/lang/String;

.field public static final j:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 28
    const-class v0, Lcom/wishabi/flipp/content/aj;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/aj;->a:Ljava/lang/String;

    .line 48
    const-string v0, "content://com.wishabi.flipp.content.SearchTerm/history"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/aj;->b:Landroid/net/Uri;

    .line 50
    const-string v0, "content://com.wishabi.flipp.content.SearchTerm/item"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/aj;->c:Landroid/net/Uri;

    .line 52
    const-string v0, "content://com.wishabi.flipp.content.SearchTerm/merchant"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/aj;->d:Landroid/net/Uri;

    .line 55
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "0 AS type"

    aput-object v1, v0, v2

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "word AS suggest_text_1"

    aput-object v1, v0, v4

    const-string v1, "word AS suggest_intent_query"

    aput-object v1, v0, v5

    const-string v1, "2130837693 AS suggest_icon_1"

    aput-object v1, v0, v6

    sput-object v0, Lcom/wishabi/flipp/content/aj;->e:[Ljava/lang/String;

    .line 63
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "1 AS type"

    aput-object v1, v0, v2

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "word AS suggest_text_1"

    aput-object v1, v0, v4

    const-string v1, "word AS suggest_intent_query"

    aput-object v1, v0, v5

    const-string v1, "2130837693 AS suggest_icon_1"

    aput-object v1, v0, v6

    sput-object v0, Lcom/wishabi/flipp/content/aj;->f:[Ljava/lang/String;

    .line 71
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "2 AS type"

    aput-object v1, v0, v2

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "word AS suggest_text_1"

    aput-object v1, v0, v4

    const-string v1, "word AS suggest_intent_query"

    aput-object v1, v0, v5

    const-string v1, "2130837696 AS suggest_icon_1"

    aput-object v1, v0, v6

    sput-object v0, Lcom/wishabi/flipp/content/aj;->g:[Ljava/lang/String;

    .line 80
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "3 AS type"

    aput-object v1, v0, v2

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "word AS suggest_text_1"

    aput-object v1, v0, v4

    const-string v1, "word AS suggest_intent_query"

    aput-object v1, v0, v5

    const-string v1, "2130837696 AS suggest_icon_1"

    aput-object v1, v0, v6

    sput-object v0, Lcom/wishabi/flipp/content/aj;->h:[Ljava/lang/String;

    .line 89
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "4 AS type"

    aput-object v1, v0, v2

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "word AS suggest_text_1"

    aput-object v1, v0, v4

    const-string v1, "word AS suggest_intent_query"

    aput-object v1, v0, v5

    const-string v1, "2130837668 AS suggest_icon_1"

    aput-object v1, v0, v6

    sput-object v0, Lcom/wishabi/flipp/content/aj;->i:[Ljava/lang/String;

    .line 97
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "5 AS type"

    aput-object v1, v0, v2

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "word AS suggest_text_1"

    aput-object v1, v0, v4

    const-string v1, "word AS suggest_intent_query"

    aput-object v1, v0, v5

    const-string v1, "2130837668 AS suggest_icon_1"

    aput-object v1, v0, v6

    sput-object v0, Lcom/wishabi/flipp/content/aj;->j:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 105
    return-void
.end method

.method public static a()Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    const/4 v3, 0x0

    .line 197
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    new-array v2, v6, [Ljava/lang/String;

    const-string v4, "DISTINCT merchant, premium"

    aput-object v4, v2, v7

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 201
    if-eqz v1, :cond_0

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_2

    .line 202
    :cond_0
    sget-object v0, Lcom/wishabi/flipp/content/aj;->a:Ljava/lang/String;

    const-string v1, "Merchant name cursor is empty"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 245
    :cond_1
    :goto_0
    return-object v3

    .line 206
    :cond_2
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 207
    sget-object v0, Lcom/wishabi/flipp/content/aj;->a:Ljava/lang/String;

    const-string v1, "Merchant name cursor is closed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 211
    :cond_3
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 212
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 213
    :goto_1
    invoke-interface {v1}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_5

    .line 214
    const-string v0, "merchant"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 215
    const-string v0, "premium"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-eqz v0, :cond_4

    move v0, v6

    .line 216
    :goto_2
    new-instance v4, Lcom/wishabi/flipp/content/al;

    invoke-direct {v4, v3, v0}, Lcom/wishabi/flipp/content/al;-><init>(Ljava/lang/String;Z)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 217
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_1

    :cond_4
    move v0, v7

    .line 215
    goto :goto_2

    .line 219
    :cond_5
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 222
    new-instance v0, Lcom/wishabi/flipp/content/ak;

    invoke-direct {v0}, Lcom/wishabi/flipp/content/ak;-><init>()V

    .line 237
    invoke-static {v2, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 240
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 241
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/al;

    .line 242
    iget-object v0, v0, Lcom/wishabi/flipp/content/al;->a:Ljava/lang/String;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3
.end method

.method public static a(I)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 155
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/wishabi/flipp/content/aj;->a(IZ)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static a(IZ)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IZ)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 159
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    .line 160
    if-nez v1, :cond_1

    .line 193
    :cond_0
    :goto_0
    return-object v0

    .line 164
    :cond_1
    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    .line 165
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v1, Ljava/io/InputStreamReader;

    invoke-direct {v1, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v4, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 167
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 170
    :goto_1
    :try_start_0
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 171
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 173
    :catch_0
    move-exception v2

    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    .line 177
    :cond_2
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    .line 178
    if-lez v2, :cond_0

    .line 182
    if-eqz p1, :cond_3

    .line 183
    invoke-static {v1}, Ljava/util/Collections;->reverse(Ljava/util/List;)V

    .line 187
    :cond_3
    :try_start_1
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V

    .line 188
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    :goto_2
    move-object v0, v1

    .line 193
    goto :goto_0

    .line 189
    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_2
.end method

.method private static a(Landroid/content/ContentResolver;I)V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 134
    if-gez p1, :cond_0

    .line 135
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 141
    :cond_0
    if-lez p1, :cond_1

    .line 142
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "_id IN (SELECT _id FROM history ORDER BY date DESC LIMIT -1 OFFSET "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 147
    :cond_1
    sget-object v1, Lcom/wishabi/flipp/content/aj;->b:Landroid/net/Uri;

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v0, v2}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 152
    :goto_0
    return-void

    .line 149
    :catch_0
    move-exception v0

    .line 150
    sget-object v1, Lcom/wishabi/flipp/content/aj;->a:Ljava/lang/String;

    const-string v2, "truncateHistory"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 130
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wishabi/flipp/content/aj;->a(Landroid/content/ContentResolver;I)V

    .line 131
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 115
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 127
    :goto_0
    return-void

    .line 119
    :cond_0
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 120
    const-string v1, "word"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    const-string v1, "date"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 123
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 125
    sget-object v2, Lcom/wishabi/flipp/content/aj;->b:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 126
    const/16 v0, 0x64

    invoke-static {v1, v0}, Lcom/wishabi/flipp/content/aj;->a(Landroid/content/ContentResolver;I)V

    goto :goto_0
.end method
