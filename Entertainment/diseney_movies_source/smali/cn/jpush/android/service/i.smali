.class final Lcn/jpush/android/service/i;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:J

.field final synthetic b:Lcn/jpush/android/service/g;


# direct methods
.method constructor <init>(Lcn/jpush/android/service/g;J)V
    .locals 0

    iput-object p1, p0, Lcn/jpush/android/service/i;->b:Lcn/jpush/android/service/g;

    iput-wide p2, p0, Lcn/jpush/android/service/i;->a:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 12

    const/4 v5, 0x1

    invoke-static {}, Lcn/jpush/android/service/g;->a()Lcn/jpush/android/data/i;

    move-result-object v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcn/jpush/android/service/i;->b:Lcn/jpush/android/service/g;

    invoke-static {v0}, Lcn/jpush/android/service/g;->a(Lcn/jpush/android/service/g;)Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v0, Lcn/jpush/android/data/i;

    iget-object v1, p0, Lcn/jpush/android/service/i;->b:Lcn/jpush/android/service/g;

    invoke-static {v1}, Lcn/jpush/android/service/g;->a(Lcn/jpush/android/service/g;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcn/jpush/android/data/i;-><init>(Landroid/content/Context;)V

    invoke-static {v0}, Lcn/jpush/android/service/g;->a(Lcn/jpush/android/data/i;)Lcn/jpush/android/data/i;

    :cond_0
    const/4 v0, 0x0

    :try_start_0
    invoke-static {}, Lcn/jpush/android/service/g;->a()Lcn/jpush/android/data/i;

    move-result-object v1

    invoke-virtual {v1}, Lcn/jpush/android/data/i;->a()V

    invoke-static {}, Lcn/jpush/android/service/g;->a()Lcn/jpush/android/data/i;

    move-result-object v1

    iget-wide v2, p0, Lcn/jpush/android/service/i;->a:J

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Lcn/jpush/android/data/i;->a(JI)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v11

    :try_start_1
    invoke-static {}, Lcn/jpush/android/service/g;->a()Lcn/jpush/android/data/i;

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v0

    invoke-static {v11, v0}, Lcn/jpush/android/data/i;->a(Landroid/database/Cursor;Lcn/jpush/android/data/k;)V

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/data/k;->c()I

    move-result v0

    if-ne v5, v0, :cond_2

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-static {}, Lcn/jpush/android/service/g;->a()Lcn/jpush/android/data/i;

    move-result-object v0

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v1

    invoke-virtual {v1}, Lcn/jpush/android/data/k;->a()I

    move-result v1

    int-to-long v1, v1

    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v5, 0x0

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v6

    invoke-virtual {v6}, Lcn/jpush/android/data/k;->d()Ljava/lang/String;

    move-result-object v6

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v7

    invoke-virtual {v7}, Lcn/jpush/android/data/k;->f()J

    move-result-wide v7

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v9

    invoke-virtual {v9}, Lcn/jpush/android/data/k;->e()J

    move-result-wide v9

    invoke-virtual/range {v0 .. v10}, Lcn/jpush/android/data/i;->b(JIIILjava/lang/String;JJ)Z

    :goto_0
    invoke-static {}, Lcn/jpush/android/service/g;->a()Lcn/jpush/android/data/i;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/data/i;->b()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-eqz v11, :cond_1

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    :cond_1
    :goto_1
    return-void

    :cond_2
    :try_start_2
    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/data/k;->b()I

    move-result v0

    if-le v0, v5, :cond_3

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-static {}, Lcn/jpush/android/service/g;->a()Lcn/jpush/android/data/i;

    move-result-object v0

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v1

    invoke-virtual {v1}, Lcn/jpush/android/data/k;->a()I

    move-result v1

    int-to-long v1, v1

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v3

    invoke-virtual {v3}, Lcn/jpush/android/data/k;->b()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v6

    invoke-virtual {v6}, Lcn/jpush/android/data/k;->d()Ljava/lang/String;

    move-result-object v6

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v7

    invoke-virtual {v7}, Lcn/jpush/android/data/k;->f()J

    move-result-wide v7

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v9

    invoke-virtual {v9}, Lcn/jpush/android/data/k;->e()J

    move-result-wide v9

    invoke-virtual/range {v0 .. v10}, Lcn/jpush/android/data/i;->b(JIIILjava/lang/String;JJ)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v0

    move-object v0, v11

    :goto_2
    if-eqz v0, :cond_1

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1

    :cond_3
    :try_start_3
    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/data/k;->b()I

    move-result v0

    if-ne v0, v5, :cond_6

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v2

    invoke-virtual {v2}, Lcn/jpush/android/data/k;->f()J

    move-result-wide v2

    cmp-long v0, v2, v0

    if-lez v0, :cond_5

    invoke-static {}, Lcn/jpush/android/util/x;->c()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    :goto_3
    if-eqz v11, :cond_4

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0

    :cond_5
    :try_start_4
    iget-object v0, p0, Lcn/jpush/android/service/i;->b:Lcn/jpush/android/service/g;

    iget-object v1, p0, Lcn/jpush/android/service/i;->b:Lcn/jpush/android/service/g;

    invoke-static {v1}, Lcn/jpush/android/service/g;->a(Lcn/jpush/android/service/g;)Landroid/content/Context;

    move-result-object v1

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v2

    invoke-virtual {v2}, Lcn/jpush/android/data/k;->d()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcn/jpush/android/service/i;->b:Lcn/jpush/android/service/g;

    invoke-static {v3}, Lcn/jpush/android/service/g;->b(Lcn/jpush/android/service/g;)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    invoke-static {v0, v1, v2, v3, v4}, Lcn/jpush/android/service/g;->a(Lcn/jpush/android/service/g;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcn/jpush/android/service/g;->a()Lcn/jpush/android/data/i;

    move-result-object v0

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v1

    invoke-virtual {v1}, Lcn/jpush/android/data/k;->a()I

    move-result v1

    int-to-long v1, v1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v6

    invoke-virtual {v6}, Lcn/jpush/android/data/k;->d()Ljava/lang/String;

    move-result-object v6

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v7

    invoke-virtual {v7}, Lcn/jpush/android/data/k;->f()J

    move-result-wide v7

    invoke-static {}, Lcn/jpush/android/service/g;->b()Lcn/jpush/android/data/k;

    move-result-object v9

    invoke-virtual {v9}, Lcn/jpush/android/data/k;->e()J

    move-result-wide v9

    invoke-virtual/range {v0 .. v10}, Lcn/jpush/android/data/i;->b(JIIILjava/lang/String;JJ)Z

    goto/16 :goto_0

    :cond_6
    invoke-static {}, Lcn/jpush/android/util/x;->c()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_0

    :catchall_1
    move-exception v1

    move-object v11, v0

    move-object v0, v1

    goto :goto_3

    :catch_1
    move-exception v1

    goto :goto_2
.end method
