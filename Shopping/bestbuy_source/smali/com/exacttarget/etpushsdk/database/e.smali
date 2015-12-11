.class public Lcom/exacttarget/etpushsdk/database/e;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 21
    const/16 v0, 0x22

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "alert"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "sound"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "badge"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "open_direct"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "category"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "start_date"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "end_date"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "message_type"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "content_type"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "page_id"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "url"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "subject"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "site_id"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "read"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "custom"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "keys"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "period_show_count"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "last_shown_date"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "next_allowed_show"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "show_count"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "message_limit"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "rolling_period"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "period_type"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "number_of_periods"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "messages_per_period"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string v2, "message_deleted"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string v2, "min_tripped"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "proximity"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "ephemeral_message"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string v2, "has_entered"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string v2, "notify_id"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string v2, "loiter_seconds"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string v2, "entry_time"

    aput-object v2, v0, v1

    sput-object v0, Lcom/exacttarget/etpushsdk/database/e;->a:[Ljava/lang/String;

    return-void
.end method

.method public static a(Ljava/lang/String;Landroid/content/ContentValues;)I
    .locals 4

    .prologue
    .line 135
    const-string v0, "id = ?"

    .line 136
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 138
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v2

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    const-string v3, "messages"

    invoke-virtual {v2, v3, p1, v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static a(Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)I
    .locals 2

    .prologue
    .line 161
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "messages"

    invoke-virtual {v0, v1, p2, p0, p1}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/data/Message;
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 178
    new-instance v0, Lcom/exacttarget/etpushsdk/data/Message;

    invoke-direct {v0}, Lcom/exacttarget/etpushsdk/data/Message;-><init>()V

    .line 180
    :try_start_0
    const-string v3, "id"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setId(Ljava/lang/String;)V

    .line 181
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "alert"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setAlert(Ljava/lang/String;)V

    .line 182
    const-string v3, "sound"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setSound(Ljava/lang/String;)V

    .line 183
    const-string v3, "badge"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setBadge(Ljava/lang/String;)V

    .line 184
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "open_direct"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setOpenDirect(Ljava/lang/String;)V

    .line 185
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "category"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setCategory(Ljava/lang/String;)V

    .line 186
    const-string v3, "start_date"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/n;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setStartDate(Ljava/util/Date;)V

    .line 187
    const-string v3, "end_date"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/n;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setEndDate(Ljava/util/Date;)V

    .line 188
    const-string v3, "message_type"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setMessageType(Ljava/lang/Integer;)V

    .line 189
    const-string v3, "content_type"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setContentType(Ljava/lang/Integer;)V

    .line 190
    const-string v3, "page_id"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setPageId(Ljava/lang/String;)V

    .line 191
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "url"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setUrl(Ljava/lang/String;)V

    .line 192
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "subject"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setSubject(Ljava/lang/String;)V

    .line 193
    const-string v3, "site_id"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setSiteId(Ljava/lang/String;)V

    .line 194
    const-string v3, "read"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-ne v3, v1, :cond_0

    move v3, v1

    :goto_0
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setRead(Ljava/lang/Boolean;)V

    .line 195
    const-string v3, "custom"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setCustom(Ljava/lang/String;)V

    .line 196
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v3

    const-string v4, "keys"

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/data/Registration;->deserializeAttributes(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setKeys(Ljava/util/ArrayList;)V

    .line 197
    const-string v3, "period_show_count"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setPeriodShowCount(Ljava/lang/Integer;)V

    .line 198
    const-string v3, "last_shown_date"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/n;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setLastShownDate(Ljava/util/Date;)V

    .line 199
    const-string v3, "next_allowed_show"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/n;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setNextAllowedShow(Ljava/util/Date;)V

    .line 200
    const-string v3, "show_count"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setShowCount(Ljava/lang/Integer;)V

    .line 201
    const-string v3, "message_limit"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setMessageLimit(Ljava/lang/Integer;)V

    .line 202
    const-string v3, "rolling_period"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-ne v3, v1, :cond_1

    move v3, v1

    :goto_1
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setIsRollingPeriod(Ljava/lang/Boolean;)V

    .line 203
    const-string v3, "period_type"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setPeriodType(Ljava/lang/Integer;)V

    .line 204
    const-string v3, "number_of_periods"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setNumberOfPeriods(Ljava/lang/Integer;)V

    .line 205
    const-string v3, "messages_per_period"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setMessagesPerPeriod(Ljava/lang/Integer;)V

    .line 206
    const-string v3, "message_deleted"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-ne v3, v1, :cond_2

    move v3, v1

    :goto_2
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setMessageDeleted(Ljava/lang/Boolean;)V

    .line 207
    const-string v3, "min_tripped"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setMinTripped(Ljava/lang/Integer;)V

    .line 208
    const-string v3, "proximity"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setProximity(I)V

    .line 209
    const-string v3, "ephemeral_message"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-ne v3, v1, :cond_3

    move v3, v1

    :goto_3
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setEphemeralMessage(Ljava/lang/Boolean;)V

    .line 210
    const-string v3, "has_entered"

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    if-ne v3, v1, :cond_4

    :goto_4
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setHasEntered(Ljava/lang/Boolean;)V

    .line 211
    const-string v1, "notify_id"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setNotifyId(Ljava/lang/Integer;)V

    .line 212
    const-string v1, "loiter_seconds"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setLoiterSeconds(Ljava/lang/Integer;)V

    .line 213
    const-string v1, "entry_time"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setEntryTime(Ljava/lang/Long;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 219
    :goto_5
    return-object v0

    :cond_0
    move v3, v2

    .line 194
    goto/16 :goto_0

    :cond_1
    move v3, v2

    .line 202
    goto/16 :goto_1

    :cond_2
    move v3, v2

    .line 206
    goto/16 :goto_2

    :cond_3
    move v3, v2

    .line 209
    goto :goto_3

    :cond_4
    move v1, v2

    .line 210
    goto :goto_4

    .line 215
    :catch_0
    move-exception v0

    .line 216
    const-string v1, "~!de"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 217
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public static a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Message;
    .locals 9

    .prologue
    const/4 v5, 0x0

    .line 82
    const-string v3, "id = ?"

    .line 84
    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p0, v4, v0

    .line 86
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "messages"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/e;->a:[Ljava/lang/String;

    const-string v8, "1"

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 98
    if-eqz v0, :cond_1

    .line 99
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 100
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/e;->a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v5

    .line 102
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 105
    :cond_1
    return-object v5
.end method

.method public static a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 8

    .prologue
    .line 109
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "messages"

    sget-object v2, Lcom/exacttarget/etpushsdk/database/e;->a:[Ljava/lang/String;

    move-object v3, p0

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 118
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 120
    if-eqz v0, :cond_1

    .line 121
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 122
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-nez v2, :cond_0

    .line 123
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/e;->a(Landroid/database/Cursor;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v2

    .line 124
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 125
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 127
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 130
    :cond_1
    return-object v1
.end method

.method public static a(Lcom/exacttarget/etpushsdk/data/Message;)V
    .locals 4

    .prologue
    .line 65
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "messages"

    const/4 v2, 0x0

    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/e;->d(Lcom/exacttarget/etpushsdk/data/Message;)Landroid/content/ContentValues;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 69
    return-void
.end method

.method public static b(Ljava/lang/String;)I
    .locals 5

    .prologue
    .line 170
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "messages"

    const-string v2, "id = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static b(Lcom/exacttarget/etpushsdk/data/Message;)V
    .locals 1

    .prologue
    .line 72
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v0

    .line 74
    if-nez v0, :cond_0

    .line 75
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/e;->a(Lcom/exacttarget/etpushsdk/data/Message;)V

    .line 79
    :goto_0
    return-void

    .line 77
    :cond_0
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/e;->c(Lcom/exacttarget/etpushsdk/data/Message;)I

    goto :goto_0
.end method

.method public static c(Lcom/exacttarget/etpushsdk/data/Message;)I
    .locals 5

    .prologue
    .line 148
    const-string v0, "id = ?"

    .line 149
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 151
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v2

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/util/i;->b()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    const-string v3, "messages"

    invoke-static {p0}, Lcom/exacttarget/etpushsdk/database/e;->d(Lcom/exacttarget/etpushsdk/data/Message;)Landroid/content/ContentValues;

    move-result-object v4

    invoke-virtual {v2, v3, v4, v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method private static d(Lcom/exacttarget/etpushsdk/data/Message;)Landroid/content/ContentValues;
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 223
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 225
    const-string v0, "id"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    const-string v0, "alert"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getAlert()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 227
    const-string v0, "sound"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getSound()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 228
    const-string v0, "badge"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getBadge()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 229
    const-string v0, "open_direct"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getOpenDirect()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    const-string v0, "category"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getCategory()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 231
    const-string v0, "start_date"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getStartDate()Ljava/util/Date;

    move-result-object v4

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/util/n;->a(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    const-string v0, "end_date"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getEndDate()Ljava/util/Date;

    move-result-object v4

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/util/n;->a(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 233
    const-string v0, "message_type"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getMessageType()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 234
    const-string v0, "content_type"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getContentType()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 235
    const-string v0, "page_id"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getPageId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 236
    const-string v0, "url"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 237
    const-string v0, "subject"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getSubject()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    const-string v0, "site_id"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getSiteId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    const-string v4, "read"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getRead()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 240
    const-string v0, "custom"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getCustom()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 241
    const-string v0, "custom"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getCustom()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 242
    const-string v0, "keys"

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getKeys()Ljava/util/ArrayList;

    move-result-object v5

    invoke-static {v5}, Lcom/exacttarget/etpushsdk/data/Registration;->serializeAttributes(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 243
    const-string v0, "period_show_count"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 244
    const-string v0, "last_shown_date"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getLastShownDate()Ljava/util/Date;

    move-result-object v4

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/util/n;->a(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    const-string v0, "next_allowed_show"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getNextAllowedShow()Ljava/util/Date;

    move-result-object v4

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/util/n;->a(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    const-string v0, "show_count"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 247
    const-string v0, "message_limit"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getMessageLimit()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 248
    const-string v4, "rolling_period"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getIsRollingPeriod()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 249
    const-string v0, "period_type"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodType()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 250
    const-string v0, "number_of_periods"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getNumberOfPeriods()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 251
    const-string v0, "messages_per_period"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getMessagesPerPeriod()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 252
    const-string v4, "message_deleted"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getMessageDeleted()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    :goto_2
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 253
    const-string v0, "min_tripped"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getMinTripped()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 254
    const-string v0, "proximity"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getProximity()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 255
    const-string v4, "ephemeral_message"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getEphemeralMessage()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_3

    move v0, v1

    :goto_3
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 256
    const-string v0, "has_entered"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getHasEntered()Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_4

    :goto_4
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 257
    const-string v0, "notify_id"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getNotifyId()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 258
    const-string v0, "loiter_seconds"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getLoiterSeconds()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 259
    const-string v0, "entry_time"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Message;->getEntryTime()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 261
    return-object v3

    :cond_0
    move v0, v2

    .line 239
    goto/16 :goto_0

    :cond_1
    move v0, v2

    .line 248
    goto/16 :goto_1

    :cond_2
    move v0, v2

    .line 252
    goto :goto_2

    :cond_3
    move v0, v2

    .line 255
    goto :goto_3

    :cond_4
    move v1, v2

    .line 256
    goto :goto_4
.end method
