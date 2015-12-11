.class Lam;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;

.field private static final o:Ljava/util/Map;


# instance fields
.field private final b:Ljava/lang/String;

.field private final c:I

.field private final d:Ljava/lang/String;

.field private final e:Ljava/lang/String;

.field private final f:Ljava/lang/Long;

.field private final g:Ljava/lang/String;

.field private final h:Ljava/lang/String;

.field private final i:Ljava/lang/Integer;

.field private final j:Ljava/lang/String;

.field private final k:Landroid/content/Context;

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 31
    const-class v0, Lam;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lam;->a:Ljava/lang/String;

    .line 175
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 178
    sput-object v0, Lam;->o:Ljava/util/Map;

    const/4 v1, 0x7

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "2g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/4 v1, 0x4

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "2g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/4 v1, 0x2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "2g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 181
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "2g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 182
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/16 v1, 0xb

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "2g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 184
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/4 v1, 0x5

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "3g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 185
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/4 v1, 0x6

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "3g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 186
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/16 v1, 0xa

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "3g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 187
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/16 v1, 0x9

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "3g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 188
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/4 v1, 0x3

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "3g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 189
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/16 v1, 0xe

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "3g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 190
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/16 v1, 0xc

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "3g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 192
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/16 v1, 0xf

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "4g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 193
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/16 v1, 0x8

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "4g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 194
    sget-object v0, Lam;->o:Ljava/util/Map;

    const/16 v1, 0xd

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "4g"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 195
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p2, p0, Lam;->m:Ljava/lang/String;

    .line 49
    invoke-static {p1}, Lam;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lam;->b:Ljava/lang/String;

    .line 50
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    iput-object v0, p0, Lam;->d:Ljava/lang/String;

    .line 51
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    iput-object v0, p0, Lam;->e:Ljava/lang/String;

    .line 52
    new-instance v0, Landroid/os/StatFs;

    invoke-static {}, Landroid/os/Environment;->getDataDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/os/StatFs;->getBlockCount()I

    move-result v1

    int-to-long v2, v1

    invoke-virtual {v0}, Landroid/os/StatFs;->getBlockSize()I

    move-result v0

    int-to-long v0, v0

    mul-long/2addr v0, v2

    const-wide/32 v2, 0x100000

    div-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lam;->f:Ljava/lang/Long;

    .line 53
    invoke-static {}, Lam;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lam;->g:Ljava/lang/String;

    .line 54
    invoke-static {}, Lam;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lam;->h:Ljava/lang/String;

    .line 55
    invoke-direct {p0}, Lam;->e()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lam;->i:Ljava/lang/Integer;

    .line 56
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    iput-object v0, p0, Lam;->j:Ljava/lang/String;

    .line 57
    iput-object p1, p0, Lam;->k:Landroid/content/Context;

    .line 58
    const/4 v0, 0x0

    iput-boolean v0, p0, Lam;->n:Z

    .line 59
    invoke-static {p1}, Lam;->b(Landroid/content/Context;)I

    move-result v0

    iput v0, p0, Lam;->c:I

    .line 60
    iput-object p3, p0, Lam;->l:Ljava/lang/String;

    .line 61
    return-void
.end method

.method private static a(Landroid/content/Context;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 64
    const-string v0, "Unknown"

    .line 66
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget-object v0, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 71
    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private static b(Landroid/content/Context;)I
    .locals 3

    .prologue
    .line 76
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 77
    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    :goto_0
    return v0

    .line 78
    :catch_0
    move-exception v0

    .line 79
    sget-object v1, Lam;->a:Ljava/lang/String;

    const-string v2, "Error retrieving application version"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 80
    const/4 v0, -0x1

    goto :goto_0
.end method

.method private static c()Ljava/lang/String;
    .locals 6

    .prologue
    .line 90
    const/4 v2, 0x0

    .line 91
    const-string v0, "Unknown"

    .line 93
    :try_start_0
    new-instance v1, Ljava/io/RandomAccessFile;

    const-string v3, "/proc/meminfo"

    const-string v4, "r"

    invoke-direct {v1, v3, v4}, Ljava/io/RandomAccessFile;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 94
    :try_start_1
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->readLine()Ljava/lang/String;

    move-result-object v0

    .line 96
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 97
    const/4 v2, 0x0

    :goto_0
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    if-ge v2, v4, :cond_1

    .line 98
    invoke-virtual {v0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v4

    .line 99
    invoke-virtual {v4}, Ljava/lang/Character;->charValue()C

    move-result v5

    invoke-static {v5}, Ljava/lang/Character;->isDigit(C)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 100
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 97
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 104
    :cond_1
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .line 105
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    const-wide/16 v4, 0x400

    div-long/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 110
    :try_start_2
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_2

    .line 119
    :cond_2
    :goto_1
    return-object v0

    .line 110
    :catch_0
    move-exception v1

    move-object v1, v2

    :goto_2
    if-eqz v1, :cond_2

    .line 112
    :try_start_3
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1

    .line 116
    :catch_1
    move-exception v1

    goto :goto_1

    .line 110
    :catchall_0
    move-exception v0

    move-object v1, v2

    :goto_3
    if-eqz v1, :cond_3

    .line 112
    :try_start_4
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_3

    .line 116
    :cond_3
    :goto_4
    throw v0

    :catch_2
    move-exception v1

    goto :goto_1

    :catch_3
    move-exception v1

    goto :goto_4

    .line 110
    :catchall_1
    move-exception v0

    goto :goto_3

    :catch_4
    move-exception v2

    goto :goto_2
.end method

.method private static c(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 164
    const-string v1, "unknown"

    .line 166
    :try_start_0
    const-string v0, "phone"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    .line 167
    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 172
    :goto_0
    if-nez v0, :cond_0

    const-string v0, "unknown"

    :cond_0
    return-object v0

    .line 168
    :catch_0
    move-exception v0

    .line 169
    const-string v2, "Error determining carrier name"

    invoke-static {v2, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    goto :goto_0
.end method

.method private static d()Ljava/lang/String;
    .locals 5

    .prologue
    .line 123
    const/4 v2, 0x0

    .line 124
    const-string v0, "Unknown"

    .line 126
    :try_start_0
    new-instance v1, Ljava/io/RandomAccessFile;

    const-string v3, "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"

    const-string v4, "r"

    invoke-direct {v1, v3, v4}, Ljava/io/RandomAccessFile;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 127
    :try_start_1
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->readLine()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 132
    :try_start_2
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_2

    .line 141
    :cond_0
    :goto_0
    return-object v0

    .line 132
    :catch_0
    move-exception v1

    move-object v1, v2

    :goto_1
    if-eqz v1, :cond_0

    .line 134
    :try_start_3
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 138
    :catch_1
    move-exception v1

    goto :goto_0

    .line 132
    :catchall_0
    move-exception v0

    :goto_2
    if-eqz v2, :cond_1

    .line 134
    :try_start_4
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_3

    .line 138
    :cond_1
    :goto_3
    throw v0

    :catch_2
    move-exception v1

    goto :goto_0

    :catch_3
    move-exception v1

    goto :goto_3

    .line 132
    :catchall_1
    move-exception v0

    move-object v2, v1

    goto :goto_2

    :catch_4
    move-exception v2

    goto :goto_1
.end method

.method private e()I
    .locals 2

    .prologue
    .line 153
    :try_start_0
    new-instance v0, Ljava/io/File;

    const-string v1, "/sys/devices/system/cpu/"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 154
    new-instance v1, Lam$a;

    invoke-direct {v1, p0}, Lam$a;-><init>(Lam;)V

    invoke-virtual {v0, v1}, Ljava/io/File;->listFiles(Ljava/io/FileFilter;)[Ljava/io/File;

    move-result-object v0

    .line 155
    array-length v0, v0
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 159
    :goto_0
    return v0

    :catch_0
    move-exception v0

    const/4 v0, -0x1

    goto :goto_0
.end method

.method private f()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 198
    :goto_0
    iget-boolean v0, p0, Lam;->n:Z

    if-eqz v0, :cond_0

    .line 199
    const-string v0, "unknown"

    .line 223
    :goto_1
    return-object v0

    .line 203
    :cond_0
    :try_start_0
    iget-object v0, p0, Lam;->k:Landroid/content/Context;

    const-string v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 204
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 205
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 206
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    if-ne v1, v3, :cond_1

    .line 207
    const-string v0, "wifi"

    goto :goto_1

    .line 208
    :cond_1
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    if-nez v1, :cond_3

    .line 209
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v0

    .line 210
    sget-object v1, Lam;->o:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 211
    sget-object v1, Lam;->o:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_1

    .line 215
    :cond_2
    const-string v0, "offline"

    goto :goto_1

    .line 218
    :catch_0
    move-exception v0

    iput-boolean v3, p0, Lam;->n:Z

    goto :goto_0

    .line 220
    :catch_1
    move-exception v0

    .line 221
    const-string v1, "Error determining connection type"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 223
    :cond_3
    const-string v0, "unknown"

    goto :goto_1
.end method


# virtual methods
.method final a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 313
    iget-object v0, p0, Lam;->b:Ljava/lang/String;

    return-object v0
.end method

.method final a(Lbd;)V
    .locals 4

    .prologue
    .line 264
    iget v0, p0, Lam;->c:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 265
    const-string v0, "avi"

    iget v1, p0, Lam;->c:I

    int-to-long v2, v1

    invoke-virtual {p1, v0, v2, v3}, Lbd;->a(Ljava/lang/String;J)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    .line 270
    :cond_0
    const-string v0, "av"

    iget-object v1, p0, Lam;->b:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "agv"

    const-string v2, "4.1.5.0"

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "ab"

    const-string v2, "4a7494a184c449ed1cdc3f18d8c1d70e96674133"

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    .line 276
    return-void
.end method

.method final a(Le;)V
    .locals 2

    .prologue
    .line 306
    const-string v0, "ky"

    iget-object v1, p0, Lam;->l:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Le;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    const-string v0, "an"

    iget-object v1, p0, Lam;->k:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Le;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 308
    const-string v0, "osn"

    const-string v1, "Android"

    invoke-virtual {p1, v0, v1}, Le;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 309
    const-string v0, "bid"

    iget-object v1, p0, Lam;->m:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Le;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 310
    return-void
.end method

.method final a(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 234
    iget v0, p0, Lam;->c:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 235
    const-string v0, "avi"

    iget v1, p0, Lam;->c:I

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 238
    :cond_0
    const-string v0, "av"

    iget-object v1, p0, Lam;->b:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 239
    const-string v0, "agv"

    const-string v1, "4.1.5.0"

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 240
    const-string v0, "ab"

    const-string v1, "4a7494a184c449ed1cdc3f18d8c1d70e96674133"

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 241
    return-void
.end method

.method public final b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 322
    iget-object v0, p0, Lam;->l:Ljava/lang/String;

    return-object v0
.end method

.method final b(Lbd;)V
    .locals 4

    .prologue
    .line 279
    const-string v0, "dm"

    iget-object v1, p0, Lam;->d:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "dmo"

    iget-object v2, p0, Lam;->e:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "ds"

    iget-object v2, p0, Lam;->f:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Lbd;->a(Ljava/lang/String;J)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "tm"

    iget-object v2, p0, Lam;->g:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "cf"

    iget-object v2, p0, Lam;->h:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "cc"

    iget-object v2, p0, Lam;->i:Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Lbd;->a(Ljava/lang/String;J)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "osv"

    iget-object v2, p0, Lam;->j:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "ca"

    iget-object v2, p0, Lam;->k:Landroid/content/Context;

    invoke-static {v2}, Lam;->c(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "ct"

    invoke-direct {p0}, Lam;->f()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "av"

    iget-object v2, p0, Lam;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    .line 300
    iget-object v0, p0, Lam;->m:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 301
    invoke-virtual {p1}, Lbd;->a()Lbd;

    move-result-object v0

    const-string v1, "bid"

    iget-object v2, p0, Lam;->m:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    .line 303
    :cond_0
    return-void
.end method

.method final b(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 244
    const-string v0, "dm"

    iget-object v1, p0, Lam;->d:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 245
    const-string v0, "dmo"

    iget-object v1, p0, Lam;->e:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 246
    const-string v0, "ds"

    iget-object v1, p0, Lam;->f:Ljava/lang/Long;

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 247
    const-string v0, "tm"

    iget-object v1, p0, Lam;->g:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 248
    const-string v0, "cf"

    iget-object v1, p0, Lam;->h:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 249
    const-string v0, "cc"

    iget-object v1, p0, Lam;->i:Ljava/lang/Integer;

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 250
    const-string v0, "osv"

    iget-object v1, p0, Lam;->j:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 251
    const-string v0, "ca"

    iget-object v1, p0, Lam;->k:Landroid/content/Context;

    invoke-static {v1}, Lam;->c(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 252
    const-string v0, "ct"

    invoke-direct {p0}, Lam;->f()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 253
    iget-object v0, p0, Lam;->m:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 254
    const-string v0, "bid"

    iget-object v1, p0, Lam;->m:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 256
    :cond_0
    return-void
.end method
