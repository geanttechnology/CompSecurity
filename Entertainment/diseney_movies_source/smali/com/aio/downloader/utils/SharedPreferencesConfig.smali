.class public Lcom/aio/downloader/utils/SharedPreferencesConfig;
.super Ljava/lang/Object;
.source "SharedPreferencesConfig.java"


# static fields
.field private static final BATTERYLOW:Ljava/lang/String; = "batterylow"

.field private static final CALLERIN:Ljava/lang/String; = "callerin"

.field private static final CALLEROUT:Ljava/lang/String; = "callerout"

.field private static final CHANGE:Ljava/lang/String; = "change"

.field private static final CLEANER:Ljava/lang/String; = "cleaner"

.field private static final CLEANERBOX:Ljava/lang/String; = "cleanerbox"

.field private static final CLEANERRAM:Ljava/lang/String; = "cleanerram"

.field private static final CLEANERUPDATE:Ljava/lang/String; = "cleanerupdate"

.field private static final GALLARY_POP:Ljava/lang/String; = "gallery_pop"

.field private static final GIFT:Ljava/lang/String; = "gift_aio"

.field private static final NEITUI:Ljava/lang/String; = "neitui_wyc"

.field private static final PIAD:Ljava/lang/String; = "piad"

.field private static final PICK:Ljava/lang/String; = "pick"

.field private static final PICK_BIG:Ljava/lang/String; = "pick_bag"

.field private static final POWERAPP:Ljava/lang/String; = "powerapp"

.field private static final POWERCHANGE:Ljava/lang/String; = "powerchange"

.field private static final SIMULATECALL:Ljava/lang/String; = "simulate_call"

.field private static final UPCLEANER:Ljava/lang/String; = "upcleaner"

.field private static final UPDATE:Ljava/lang/String; = "update"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static GetBatteryLowClickTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 63
    .line 64
    const-string v1, "batterylow"

    const/4 v2, 0x0

    .line 63
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 65
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "batterylow"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetCallerTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 228
    const-string v1, "callerin"

    .line 229
    const/4 v2, 0x0

    .line 228
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 230
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "caller"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetCalleroutTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 243
    const-string v1, "callerout"

    .line 244
    const/4 v2, 0x0

    .line 243
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 245
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "callerout"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetChangeTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 168
    const-string v1, "change"

    .line 169
    const/4 v2, 0x0

    .line 168
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 170
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "change"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetCleanerBoxTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 258
    .line 259
    const-string v1, "cleanerbox"

    const/4 v2, 0x0

    .line 258
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 260
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "cleanerbox"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetCleanerRamClickTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 78
    .line 79
    const-string v1, "cleanerram"

    const/4 v2, 0x0

    .line 78
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 80
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "cleanerram"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetCleanerTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 183
    const-string v1, "cleaner"

    .line 184
    const/4 v2, 0x0

    .line 183
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 185
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "cleaner"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetCleanerUpdateTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 273
    .line 274
    const-string v1, "cleanerupdate"

    const/4 v2, 0x0

    .line 273
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 275
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "cleanerupdate"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetClickTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 33
    const-string v1, "gift_aio"

    .line 34
    const/4 v2, 0x0

    .line 33
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 35
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "gift_aio"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetGalleryClickTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 48
    .line 49
    const-string v1, "gallery_pop"

    const/4 v2, 0x0

    .line 48
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 50
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "gallery_pop"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetPiadTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 138
    const-string v1, "piad"

    .line 139
    const/4 v2, 0x0

    .line 138
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 140
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "piad"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetPickClickTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 123
    const-string v1, "pick"

    .line 124
    const/4 v2, 0x0

    .line 123
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 125
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "pick"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetPick_bigTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 153
    const-string v1, "pick_bag"

    .line 154
    const/4 v2, 0x0

    .line 153
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 155
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "pick_big"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetPowerAPPClickTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 108
    const-string v1, "powerapp"

    .line 109
    const/4 v2, 0x0

    .line 108
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 110
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "powerapp"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetPowerChangeClickTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 93
    .line 94
    const-string v1, "powerchange"

    const/4 v2, 0x0

    .line 93
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 95
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "powerchange"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetUpcleanerTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 213
    const-string v1, "upcleaner"

    .line 214
    const/4 v2, 0x0

    .line 213
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 215
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "upcleaner"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static GetUpdateTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 198
    const-string v1, "update"

    .line 199
    const/4 v2, 0x0

    .line 198
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 200
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "update"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static Getneitui(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 303
    .line 304
    const-string v1, "neitui_wyc"

    const/4 v2, 0x0

    .line 303
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 305
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "neitui_wyc"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static Getsimulate_callTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 288
    .line 289
    const-string v1, "simulate_call"

    const/4 v2, 0x0

    .line 288
    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 290
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "simulate_call"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    return-wide v1
.end method

.method public static SetBatteryLowClickTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 69
    .line 70
    const-string v2, "batterylow"

    const/4 v3, 0x0

    .line 69
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 71
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 72
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "batterylow"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 73
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 74
    return-void
.end method

.method public static SetCallerTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 234
    const-string v2, "callerin"

    .line 235
    const/4 v3, 0x0

    .line 234
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 236
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 237
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "caller"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 238
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 239
    return-void
.end method

.method public static SetCalleroutTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 249
    const-string v2, "callerout"

    .line 250
    const/4 v3, 0x0

    .line 249
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 251
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 252
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "callerout"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 253
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 254
    return-void
.end method

.method public static SetChangeTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 174
    const-string v2, "change"

    .line 175
    const/4 v3, 0x0

    .line 174
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 176
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 177
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "change"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 178
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 179
    return-void
.end method

.method public static SetCleanerBoxTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 264
    .line 265
    const-string v2, "cleanerbox"

    const/4 v3, 0x0

    .line 264
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 266
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 267
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "cleanerbox"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 268
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 269
    return-void
.end method

.method public static SetCleanerRamClickTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 84
    .line 85
    const-string v2, "cleanerram"

    const/4 v3, 0x0

    .line 84
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 86
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 87
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "cleanerram"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 88
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 89
    return-void
.end method

.method public static SetCleanerTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 189
    const-string v2, "cleaner"

    .line 190
    const/4 v3, 0x0

    .line 189
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 191
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 192
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "cleaner"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 193
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 194
    return-void
.end method

.method public static SetCleanerUpdateTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 279
    .line 280
    const-string v2, "cleanerupdate"

    const/4 v3, 0x0

    .line 279
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 281
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 282
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "cleanerupdate"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 283
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 284
    return-void
.end method

.method public static SetClickTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 39
    const-string v2, "gift_aio"

    .line 40
    const/4 v3, 0x0

    .line 39
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 41
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 42
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "gift_aio"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 43
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 44
    return-void
.end method

.method public static SetGalleryClickTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 54
    .line 55
    const-string v2, "gallery_pop"

    const/4 v3, 0x0

    .line 54
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 56
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 57
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "gallery_pop"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 58
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 59
    return-void
.end method

.method public static SetPiadTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 144
    const-string v2, "piad"

    .line 145
    const/4 v3, 0x0

    .line 144
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 146
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 147
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "piad"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 148
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 149
    return-void
.end method

.method public static SetPickClickTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 129
    const-string v2, "pick"

    .line 130
    const/4 v3, 0x0

    .line 129
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 131
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 132
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "pick"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 133
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 134
    return-void
.end method

.method public static SetPick_bigTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 159
    const-string v2, "pick_bag"

    .line 160
    const/4 v3, 0x0

    .line 159
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 161
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 162
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "pick_big"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 163
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 164
    return-void
.end method

.method public static SetPowerAPPClickTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 114
    const-string v2, "powerapp"

    .line 115
    const/4 v3, 0x0

    .line 114
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 116
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 117
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "powerapp"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 118
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 119
    return-void
.end method

.method public static SetPowerChangeClickTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 99
    .line 100
    const-string v2, "powerchange"

    const/4 v3, 0x0

    .line 99
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 101
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 102
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "powerchange"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 103
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 104
    return-void
.end method

.method public static SetUpcleanerTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 219
    const-string v2, "upcleaner"

    .line 220
    const/4 v3, 0x0

    .line 219
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 221
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 222
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "upcleaner"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 223
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 224
    return-void
.end method

.method public static SetUpdateTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 204
    const-string v2, "update"

    .line 205
    const/4 v3, 0x0

    .line 204
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 206
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 207
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "update"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 208
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 209
    return-void
.end method

.method public static Setneitui(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 309
    .line 310
    const-string v2, "neitui_wyc"

    const/4 v3, 0x0

    .line 309
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 311
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 312
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "neitui_wyc"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 313
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 314
    return-void
.end method

.method public static Setsimulate_callTime(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "bol"    # J

    .prologue
    .line 294
    .line 295
    const-string v2, "simulate_call"

    const/4 v3, 0x0

    .line 294
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 296
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 297
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "simulate_call"

    invoke-interface {v0, v2, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 298
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 299
    return-void
.end method
