.class public Lcom/exacttarget/etpushsdk/util/d;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static a:Ljava/lang/String;

.field private static b:Ljava/lang/String;

.field private static c:Ljava/lang/String;

.field private static d:Ljava/lang/String;

.field private static e:Z

.field private static f:Z

.field private static g:Z

.field private static h:Z

.field private static i:Ljava/lang/Boolean;

.field private static j:Ljava/util/HashMap;

.field private static k:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 36
    sput-object v1, Lcom/exacttarget/etpushsdk/util/d;->d:Ljava/lang/String;

    .line 37
    sput-boolean v0, Lcom/exacttarget/etpushsdk/util/d;->e:Z

    .line 38
    sput-boolean v0, Lcom/exacttarget/etpushsdk/util/d;->f:Z

    .line 39
    sput-boolean v0, Lcom/exacttarget/etpushsdk/util/d;->g:Z

    .line 40
    sput-boolean v0, Lcom/exacttarget/etpushsdk/util/d;->h:Z

    .line 41
    sput-object v1, Lcom/exacttarget/etpushsdk/util/d;->i:Ljava/lang/Boolean;

    .line 42
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/exacttarget/etpushsdk/util/d;->j:Ljava/util/HashMap;

    return-void
.end method

.method public static varargs a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "CommitPrefEdits"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    const/4 v3, 0x0

    .line 129
    const-string v0, "ETPush"

    invoke-virtual {p0, v0, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 132
    array-length v0, p3

    if-lez v0, :cond_0

    .line 133
    aget-object v0, p3, v3

    check-cast v0, Landroid/content/SharedPreferences;

    .line 135
    invoke-interface {v0, p1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_16

    .line 147
    :cond_0
    :goto_0
    if-eqz v1, :cond_5

    .line 149
    instance-of v0, p2, Ljava/lang/Boolean;

    if-eqz v0, :cond_1

    .line 150
    check-cast p2, Ljava/lang/Boolean;

    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-interface {v1, p1, v0}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 162
    :goto_1
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1, p1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 221
    :goto_2
    return-object v0

    .line 151
    :cond_1
    instance-of v0, p2, Ljava/lang/Float;

    if-eqz v0, :cond_2

    .line 152
    check-cast p2, Ljava/lang/Float;

    invoke-virtual {p2}, Ljava/lang/Float;->floatValue()F

    move-result v0

    invoke-interface {v1, p1, v0}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    goto :goto_1

    .line 153
    :cond_2
    instance-of v0, p2, Ljava/lang/Integer;

    if-eqz v0, :cond_3

    .line 154
    check-cast p2, Ljava/lang/Integer;

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-interface {v1, p1, v0}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_1

    .line 155
    :cond_3
    instance-of v0, p2, Ljava/lang/Long;

    if-eqz v0, :cond_4

    .line 156
    check-cast p2, Ljava/lang/Long;

    invoke-virtual {p2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-interface {v1, p1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    goto :goto_1

    .line 158
    :cond_4
    check-cast p2, Ljava/lang/String;

    invoke-interface {v1, p1, p2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 164
    :cond_5
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->j:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    invoke-static {p1}, Lcom/exacttarget/etpushsdk/util/d;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v0}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 167
    :cond_6
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->j:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 168
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->j:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 173
    :goto_3
    instance-of v1, p2, Ljava/lang/Boolean;

    if-eqz v1, :cond_8

    .line 174
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_2

    .line 170
    :cond_7
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/util/d;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v0, v1}, Lcom/exacttarget/etpushsdk/util/a;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 171
    sget-object v1, Lcom/exacttarget/etpushsdk/util/d;->j:Ljava/util/HashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    .line 175
    :cond_8
    instance-of v1, p2, Ljava/lang/Float;

    if-eqz v1, :cond_9

    .line 176
    invoke-static {v0}, Ljava/lang/Float;->valueOf(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object v0

    goto/16 :goto_2

    .line 177
    :cond_9
    instance-of v1, p2, Ljava/lang/Integer;

    if-eqz v1, :cond_a

    .line 178
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    goto/16 :goto_2

    .line 179
    :cond_a
    instance-of v1, p2, Ljava/lang/Long;

    if-eqz v1, :cond_b

    .line 180
    invoke-static {v0}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    goto/16 :goto_2

    .line 182
    :cond_b
    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_2

    .line 184
    :cond_c
    invoke-interface {v2, p1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_15

    .line 187
    instance-of v0, p2, Ljava/lang/Boolean;

    if-eqz v0, :cond_d

    move-object v0, p2

    .line 188
    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-interface {v2, p1, v0}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 200
    :goto_4
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 203
    instance-of v0, p2, Ljava/lang/Boolean;

    if-eqz v0, :cond_11

    move-object v0, v1

    .line 204
    check-cast v0, Ljava/lang/Boolean;

    invoke-static {p0, p1, v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 215
    :goto_5
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-object v0, v1

    goto/16 :goto_2

    .line 189
    :cond_d
    instance-of v0, p2, Ljava/lang/Float;

    if-eqz v0, :cond_e

    move-object v0, p2

    .line 190
    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    invoke-interface {v2, p1, v0}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    goto :goto_4

    .line 191
    :cond_e
    instance-of v0, p2, Ljava/lang/Integer;

    if-eqz v0, :cond_f

    move-object v0, p2

    .line 192
    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-interface {v2, p1, v0}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_4

    .line 193
    :cond_f
    instance-of v0, p2, Ljava/lang/Long;

    if-eqz v0, :cond_10

    move-object v0, p2

    .line 194
    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-interface {v2, p1, v0, v1}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    goto :goto_4

    :cond_10
    move-object v0, p2

    .line 196
    check-cast v0, Ljava/lang/String;

    invoke-interface {v2, p1, v0}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_4

    .line 205
    :cond_11
    instance-of v0, p2, Ljava/lang/Float;

    if-eqz v0, :cond_12

    .line 206
    check-cast p2, Ljava/lang/Float;

    invoke-static {p0, p1, p2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Float;)V

    goto :goto_5

    .line 207
    :cond_12
    instance-of v0, p2, Ljava/lang/Integer;

    if-eqz v0, :cond_13

    .line 208
    check-cast p2, Ljava/lang/Integer;

    invoke-static {p0, p1, p2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V

    goto :goto_5

    .line 209
    :cond_13
    instance-of v0, p2, Ljava/lang/Long;

    if-eqz v0, :cond_14

    .line 210
    check-cast p2, Ljava/lang/Long;

    invoke-static {p0, p1, p2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;)V

    goto :goto_5

    .line 212
    :cond_14
    check-cast p2, Ljava/lang/String;

    invoke-static {p0, p1, p2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_5

    :cond_15
    move-object v0, p2

    .line 218
    goto/16 :goto_2

    :cond_16
    move-object v1, v0

    goto/16 :goto_0
.end method

.method public static a()V
    .locals 0

    .prologue
    .line 48
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->e()Ljava/lang/String;

    .line 49
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 250
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/exacttarget/etpushsdk/util/f;

    invoke-direct {v1, p1, p0}, Lcom/exacttarget/etpushsdk/util/f;-><init>(Ljava/lang/String;Landroid/content/Context;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 257
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 1

    .prologue
    .line 237
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Float;)V
    .locals 1

    .prologue
    .line 225
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 1

    .prologue
    .line 229
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;)V
    .locals 1

    .prologue
    .line 233
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 234
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 241
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->j:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 242
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/exacttarget/etpushsdk/util/e;

    invoke-direct {v1, p0, p1, p2}, Lcom/exacttarget/etpushsdk/util/e;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 247
    return-void
.end method

.method public static a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 56
    sput-object p0, Lcom/exacttarget/etpushsdk/util/d;->a:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public static a(Z)V
    .locals 0

    .prologue
    .line 91
    sput-boolean p0, Lcom/exacttarget/etpushsdk/util/d;->e:Z

    .line 92
    return-void
.end method

.method public static a(Landroid/content/Context;)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 264
    sget-object v1, Lcom/exacttarget/etpushsdk/util/d;->i:Ljava/lang/Boolean;

    if-nez v1, :cond_0

    .line 266
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x80

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 267
    iget-object v1, v1, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    .line 268
    const-string v2, "etpush_readonly"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    sput-object v1, Lcom/exacttarget/etpushsdk/util/d;->i:Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 275
    :cond_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->i:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    :goto_0
    return v0

    .line 269
    :catch_0
    move-exception v1

    .line 270
    const-string v2, "~!ud"

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public static b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->a:Ljava/lang/String;

    return-object v0
.end method

.method public static b(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 64
    sput-object p0, Lcom/exacttarget/etpushsdk/util/d;->b:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public static b(Z)V
    .locals 0

    .prologue
    .line 99
    sput-boolean p0, Lcom/exacttarget/etpushsdk/util/d;->f:Z

    .line 100
    return-void
.end method

.method public static c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->b:Ljava/lang/String;

    return-object v0
.end method

.method public static c(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 72
    sput-object p0, Lcom/exacttarget/etpushsdk/util/d;->c:Ljava/lang/String;

    .line 73
    return-void
.end method

.method public static c(Z)V
    .locals 0

    .prologue
    .line 107
    sput-boolean p0, Lcom/exacttarget/etpushsdk/util/d;->g:Z

    .line 108
    return-void
.end method

.method public static d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->c:Ljava/lang/String;

    return-object v0
.end method

.method public static d(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 260
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_enc"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static d(Z)V
    .locals 0

    .prologue
    .line 115
    sput-boolean p0, Lcom/exacttarget/etpushsdk/util/d;->k:Z

    .line 116
    return-void
.end method

.method protected static declared-synchronized e()Ljava/lang/String;
    .locals 3

    .prologue
    .line 77
    const-class v1, Lcom/exacttarget/etpushsdk/util/d;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->d:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 79
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "--"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->c()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/util/n;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "__"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/util/g;->uniqueDeviceIdentifier(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/util/n;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/n;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 80
    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    const/4 v2, 0x2

    invoke-static {v0, v2}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/util/d;->d:Ljava/lang/String;

    .line 83
    :cond_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->d:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 77
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static e(Z)V
    .locals 0

    .prologue
    .line 123
    sput-boolean p0, Lcom/exacttarget/etpushsdk/util/d;->h:Z

    .line 124
    return-void
.end method

.method public static f()Z
    .locals 1

    .prologue
    .line 87
    sget-boolean v0, Lcom/exacttarget/etpushsdk/util/d;->e:Z

    return v0
.end method

.method public static g()Z
    .locals 1

    .prologue
    .line 95
    sget-boolean v0, Lcom/exacttarget/etpushsdk/util/d;->f:Z

    return v0
.end method

.method public static h()Z
    .locals 1

    .prologue
    .line 103
    sget-boolean v0, Lcom/exacttarget/etpushsdk/util/d;->g:Z

    return v0
.end method

.method public static i()Z
    .locals 1

    .prologue
    .line 111
    sget-boolean v0, Lcom/exacttarget/etpushsdk/util/d;->k:Z

    return v0
.end method

.method public static j()Z
    .locals 1

    .prologue
    .line 119
    sget-boolean v0, Lcom/exacttarget/etpushsdk/util/d;->h:Z

    return v0
.end method

.method static synthetic k()Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/exacttarget/etpushsdk/util/d;->j:Ljava/util/HashMap;

    return-object v0
.end method
